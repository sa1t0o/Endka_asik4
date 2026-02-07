package com.example.as4.controller;

import com.example.as4.model.dto.FootballerDTO;
import com.example.as4.service.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FootballerController {
    private final FootballerService footballerService;
    @Autowired
    public FootballerController(FootballerService footballerService){
        this.footballerService = footballerService;
    }
    @PostMapping
    public ResponseEntity<FootballerDTO> create(@RequestBody FootballerDTO dto) {
        return ResponseEntity.ok(footballerService.create(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<FootballerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(footballerService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<FootballerDTO>> getAll() {
        return ResponseEntity.ok(footballerService.getAll());
    }
}













