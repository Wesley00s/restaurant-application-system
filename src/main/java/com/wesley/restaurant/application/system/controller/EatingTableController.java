package com.wesley.restaurant.application.system.controller;

import com.wesley.restaurant.application.system.dto.EatingTableDto;
import com.wesley.restaurant.application.system.dto.EatingTableView;
import com.wesley.restaurant.application.system.entity.EatingTable;
import com.wesley.restaurant.application.system.services.implemented.EatingTableService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/table")
public class EatingTableController {
    private final EatingTableService eatingTableService;

    public EatingTableController(EatingTableService eatingTableService) {
        this.eatingTableService = eatingTableService;
    }

    @PostMapping
    private ResponseEntity<String> saveTable(@RequestBody @Valid EatingTableDto eatingTableDto) {
        EatingTable eatingTable = this.eatingTableService.save(eatingTableDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Table " + eatingTable.getTableId() + " saved");
    }

    @GetMapping("/{id}")
    private ResponseEntity<EatingTableView> findById(@PathVariable Long id) {
        EatingTable eatingTable = this.eatingTableService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new EatingTableView(eatingTable));
    }

    @GetMapping("/all-tables")
    private ResponseEntity<List<EatingTableView>> findAll() {
        List<EatingTableView> eatingTables = this.eatingTableService.findAll().stream()
                .map(EatingTableView::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(eatingTables);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) {
        this.eatingTableService.deleteById(id);
    }
}
