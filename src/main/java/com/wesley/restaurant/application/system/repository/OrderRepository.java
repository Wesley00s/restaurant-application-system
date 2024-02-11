package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
