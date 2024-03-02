package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.*;

import java.util.UUID;


public interface IRequestService {
    Request save(Request request);
    Request findById(UUID requestId);
    void deleteById(UUID requestId);
//    Request requestItem(Long clientId, Long itemId, Long eatingTableId, Long employeeId);
}
