package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.EatingTable;
import com.wesley.restaurant.application.system.repository.EatingTableRepository;
import com.wesley.restaurant.application.system.services.IEatingTableService;

import java.util.Optional;

public class EatingTableService implements IEatingTableService {
    private EatingTableRepository eatingTableRepository;

    @Override
    public EatingTable save(EatingTable eatingTable) {
        return this.eatingTableRepository.save(eatingTable);
    }

    @Override
    public EatingTable findById(Long tableId) {
        return this.eatingTableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("ID" + tableId + "not found"));
    }

    @Override
    public void delete(Long tableId) {
        Optional<EatingTable> optionalEatingTable = this.eatingTableRepository.findById(tableId);

        if (optionalEatingTable.isPresent()) {
            EatingTable eatingTableToDelete = optionalEatingTable.get();
            this.eatingTableRepository.delete(eatingTableToDelete);
        } else {
            throw new RuntimeException("Table with ID " + tableId + " not found");
        }
    }
}
