package com.wesley.restaurant.application.system.entity;

import com.wesley.restaurant.application.system.enumeration.Role;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User  implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String numberPhone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false) @Embedded
    private Address address;

    @Column(nullable = false)
    private Role role;

    public User(String userName, String numberPhone, String email, String password, String cpf, Address address, Role role) {
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
        this.role = role;
    }

    public User(Long userId, String userName, String numberPhone, String email, String password, String cpf, Address address, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.address = address;
        this.role = role;
    }

    public User() {

    }

    public User(Long userId) {
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    //
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        if(this.role.equals(Role.ADMIN)) return List.of(
//                new SimpleGrantedAuthority("ROLE_ADMIN"),
//                new SimpleGrantedAuthority("ROLE_CHEF"),
//                new SimpleGrantedAuthority("ROLE_WAITER"),
//                new SimpleGrantedAuthority("ROLE_USER")
//            );
//        else if (this.role.equals(Role.CHEF)) return List.of(
//                new SimpleGrantedAuthority("ROLE_CHEF"),
//                new SimpleGrantedAuthority("ROLE_WAITER"),
//                new SimpleGrantedAuthority("ROLE_USER")
//            );
//        else if (this.role.equals(Role.WAITER)) return List.of(
//                new SimpleGrantedAuthority("ROLE_WAITER"),
//                new SimpleGrantedAuthority("ROLE_USER")
//            );
//         return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
