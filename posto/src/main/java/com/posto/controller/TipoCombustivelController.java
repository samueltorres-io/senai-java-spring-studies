package com.posto.controller;

import com.posto.dto.TipoCombustivelRequest;
import com.posto.dto.TipoCombustivelResponse;
import com.posto.service.TipoCombustivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipos-combustivel")
public class TipoCombustivelController {

    @Autowired
    private TipoCombustivelService service;

    @PostMapping
    public ResponseEntity<TipoCombustivelResponse> create(@Valid @RequestBody TipoCombustivelRequest request) {
        TipoCombustivelResponse response = service.create(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri();
        
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TipoCombustivelResponse>> getAll() {
        List<TipoCombustivelResponse> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustivelResponse> getById(@PathVariable Long id) {
        TipoCombustivelResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCombustivelResponse> update(@PathVariable Long id, @Valid @RequestBody TipoCombustivelRequest request) {
        TipoCombustivelResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}