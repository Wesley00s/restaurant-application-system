package com.wesley.restaurant.application.system.services.implemented;

import com.wesley.restaurant.application.system.entity.EatingTable;
import com.wesley.restaurant.application.system.repository.EatingTableRepository;
import com.wesley.restaurant.application.system.services.IEatingTableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EatingTableService implements IEatingTableService {
    private final EatingTableRepository eatingTableRepository;

    public EatingTableService(EatingTableRepository eatingTableRepository) {
        this.eatingTableRepository = eatingTableRepository;
    }

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
    public List<EatingTable> findAll() {
        return this.eatingTableRepository.findAll();
    }

    @Override
    public void deleteById(Long tableId) {
        Optional<EatingTable> optionalEatingTable = this.eatingTableRepository.findById(tableId);

        if (optionalEatingTable.isPresent()) {
            EatingTable eatingTableToDelete = optionalEatingTable.get();
            this.eatingTableRepository.delete(eatingTableToDelete);
        } else {
            throw new RuntimeException("Table with ID " + tableId + " not found");
        }
    }
}
