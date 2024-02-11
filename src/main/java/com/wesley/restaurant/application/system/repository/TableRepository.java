package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
