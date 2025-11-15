package com.posto.controller;

import com.posto.dto.AbastecimentoRequest;
import com.posto.dto.AbastecimentoResponse;
import com.posto.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService service;

    @PostMapping
    public ResponseEntity<AbastecimentoResponse> create(@Valid @RequestBody AbastecimentoRequest request) {
        AbastecimentoResponse response = service.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AbastecimentoResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbastecimentoResponse> update(@PathVariable Long id, @Valid @RequestBody AbastecimentoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
