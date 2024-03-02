package com.wesley.restaurant.application.system.repository;

import com.wesley.restaurant.application.system.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {
//    Request requestItem(Long clientId, Long itemId, Long eatingTableId, Long employeeId);
}
