package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
