package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
