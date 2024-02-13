package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.EatingTable;

public interface IEatingTableService {
    EatingTable save(EatingTable eatingTable);
    EatingTable findById(Long tableId);
    void delete(Long tableId);
}
