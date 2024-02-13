package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.Request;


public interface IRequestService {
    Request save(Request request);
    Request findById(Long requestId);
    void deleteById(Long requestId);
}
