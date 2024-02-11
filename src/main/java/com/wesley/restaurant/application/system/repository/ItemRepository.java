package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item WHERE client_id = ?1", nativeQuery = true)
    List<Item> findAlLByClient(Long clientId);
}
