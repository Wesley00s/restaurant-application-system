package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {
}
