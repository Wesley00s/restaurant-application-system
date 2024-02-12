package com.wesley.restaurant.application.system.services;

import com.wesley.restaurant.application.system.entity.EatingTable;

import java.util.List;

public interface IEatingTableService {
    EatingTable save(EatingTable eatingTable);
    EatingTable findById(Long tableId);
    List<EatingTable> findAll();
    void deleteById(Long tableId);
}
