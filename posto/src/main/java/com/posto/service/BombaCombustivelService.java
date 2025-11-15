package com.posto.service;

import com.posto.dto.BombaCombustivelRequest;
import com.posto.dto.BombaCombustivelResponse;
import com.posto.model.BombaCombustivel;
import com.posto.model.TipoCombustivel;
import com.posto.exception.ResourceNotFoundException;
import com.posto.repository.BombaCombustivelRepository;
import com.posto.repository.TipoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BombaCombustivelService {

    @Autowired
    private BombaCombustivelRepository bombaRepository;

    @Autowired
    private TipoCombustivelRepository tipoCombustivelRepository;

    @Transactional
    public BombaCombustivelResponse create(BombaCombustivelRequest request) {
        TipoCombustivel tipoCombustivel = tipoCombustivelRepository.findById(request.tipoCombustivelId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de Combustível não encontrado com ID: " + request.tipoCombustivelId()));

        BombaCombustivel entity = new BombaCombustivel();
        entity.setNome(request.nome());
        entity.setTipoCombustivel(tipoCombustivel);

        BombaCombustivel savedEntity = bombaRepository.save(entity);

        return new BombaCombustivelResponse(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<BombaCombustivelResponse> getAll() {
        return bombaRepository.findAll()
                .stream()
                .map(BombaCombustivelResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BombaCombustivelResponse getById(Long id) {
        BombaCombustivel entity = bombaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bomba não encontrada com ID: " + id));
        return new BombaCombustivelResponse(entity);
    }

    @Transactional
    public BombaCombustivelResponse update(Long id, BombaCombustivelRequest request) {
        BombaCombustivel entity = bombaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bomba não encontrada com ID: " + id));

        TipoCombustivel tipoCombustivel = tipoCombustivelRepository.findById(request.tipoCombustivelId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de Combustível não encontrado com ID: " + request.tipoCombustivelId()));

        entity.setNome(request.nome());
        entity.setTipoCombustivel(tipoCombustivel);

        BombaCombustivel updatedEntity = bombaRepository.save(entity);
        return new BombaCombustivelResponse(updatedEntity);
    }

    @Transactional
    public void delete(Long id) {
        if (!bombaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bomba não encontrada com ID: " + id);
        }
        
        bombaRepository.deleteById(id);
    }
}