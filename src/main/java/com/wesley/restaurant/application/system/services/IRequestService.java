package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Request;

import java.util.UUID;


public interface IRequestService {
    Request save(Request request);
    Request findById(UUID requestId);
    void deleteById(UUID requestId);
}
