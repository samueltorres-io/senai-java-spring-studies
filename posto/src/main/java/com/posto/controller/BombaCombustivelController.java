package com.posto.controller;

import com.posto.dto.BombaCombustivelRequest;
import com.posto.dto.BombaCombustivelResponse;
import com.posto.service.BombaCombustivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bombas")
public class BombaCombustivelController {

    @Autowired
    private BombaCombustivelService service;

    @PostMapping
    public ResponseEntity<BombaCombustivelResponse> create(@Valid @RequestBody BombaCombustivelRequest request) {
        BombaCombustivelResponse response = service.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BombaCombustivelResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BombaCombustivelResponse> update(@PathVariable Long id, @Valid @RequestBody BombaCombustivelRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
