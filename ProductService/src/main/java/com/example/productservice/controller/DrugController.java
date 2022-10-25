package com.example.productservice.controller;

import com.example.productservice.mapper.DrugMapper;
import com.example.productservice.model.dto.DrugDto;
import com.example.productservice.service.DrugService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/drug")
@Slf4j
public class DrugController {
    private final DrugService drugService;
    private final DrugMapper drugMapper;

    @GetMapping("/{id}")
    public ResponseEntity<DrugDto> findDetailDrug(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(drugMapper.entityToDto(drugService.findDrugById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DrugDto>> findAllDrugs() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(drugService.findAllDrugs().stream().map(drugMapper::entityToDto).toList());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable Long id) {
        drugService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/add")
    public ResponseEntity<DrugDto> addDrug(@RequestBody DrugDto drugDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(drugMapper.entityToDto(drugService.save(drugDto)));
    }
}
