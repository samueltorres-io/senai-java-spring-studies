package com.posto.service;

import com.posto.dto.TipoCombustivelRequest;
import com.posto.dto.TipoCombustivelResponse;
import com.posto.model.TipoCombustivel;
import com.posto.exception.ResourceNotFoundException;
import com.posto.repository.TipoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCombustivelService {

    @Autowired
    private TipoCombustivelRepository repository;

    @Transactional
    public TipoCombustivelResponse create(TipoCombustivelRequest request) {
        TipoCombustivel entity = new TipoCombustivel();
        entity.setNome(request.nome());
        entity.setPrecoPorLitro(request.precoPorLitro());

        TipoCombustivel savedEntity = repository.save(entity);

        return new TipoCombustivelResponse(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<TipoCombustivelResponse> getAll() {
        List<TipoCombustivel> entities = repository.findAll();

        return entities.stream()
                .map(TipoCombustivelResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TipoCombustivelResponse getById(Long id) {
        TipoCombustivel entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de Combustível não encontrado com ID: " + id));
        
        return new TipoCombustivelResponse(entity);
    }

    @Transactional
    public TipoCombustivelResponse update(Long id, TipoCombustivelRequest request) {
        TipoCombustivel entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de Combustível não encontrado com ID: " + id));

        entity.setNome(request.nome());
        entity.setPrecoPorLitro(request.precoPorLitro());

        TipoCombustivel updatedEntity = repository.save(entity);

        return new TipoCombustivelResponse(updatedEntity);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Tipo de Combustível não encontrado com ID: " + id);
        }
        
        repository.deleteById(id);
    }
}