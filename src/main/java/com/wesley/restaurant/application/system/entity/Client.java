package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends User {
    public Client(String userName, String numberPhone, String email, String password, String cpf, Address address) {
        super(userName, numberPhone, email, password, cpf, address, Role.CLIENT);
    }

    public Client(Long clientId, String userName, String numberPhone, String email, String password, String cpf, Address address) {
        super(clientId, userName, numberPhone, email, password, cpf, address, Role.CLIENT);

    }
    public Client() {}

    public Client(Long clientId) {
    }

    public Client(String login, String encryptPassword, Role role) {
        this.setEmail(login);
        this.setPassword(encryptPassword);
        this.setRole(role);
    }

    public Request requestItem(Item item, EatingTable eatingTable, Employee employee) {
        for (Ingredient ingredient : item.getIngredients()) {
            int newQuantity = ingredient.getQuantityInStock() - 1;
            if (newQuantity < 0) {
//                throw new InsufficientStockException("Insufficient quantity for ingredient: " + ingredient.getName());
                throw new RuntimeException("Insufficient quantity for ingredient: " + ingredient.getIngredientName());
            }
            ingredient.setQuantityInStock(newQuantity);
        }

        return new Request(this, item, eatingTable, employee);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("CLIENT"));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}