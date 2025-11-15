package com.posto.service;

import com.posto.dto.AbastecimentoRequest;
import com.posto.dto.AbastecimentoResponse;
import com.posto.model.Abastecimento;
import com.posto.model.BombaCombustivel;
import com.posto.exception.ResourceNotFoundException;
import com.posto.repository.AbastecimentoRepository;
import com.posto.repository.BombaCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private BombaCombustivelRepository bombaRepository;

    @Transactional
    public AbastecimentoResponse create(AbastecimentoRequest request) {
        BombaCombustivel bomba = bombaRepository.findById(request.bombaId())
                .orElseThrow(() -> new ResourceNotFoundException("Bomba não encontrada com ID: " + request.bombaId()));

        BigDecimal precoPorLitro = bomba.getTipoCombustivel().getPrecoPorLitro();

        BigDecimal valorTotal = request.valorTotalAbastecido();

        BigDecimal litragem = valorTotal.divide(precoPorLitro, 3, RoundingMode.HALF_UP);

        Abastecimento entity = new Abastecimento();
        entity.setBomba(bomba);
        entity.setDataAbastecimento(LocalDateTime.now());
        entity.setValorTotal(valorTotal);
        entity.setLitragem(litragem);

        Abastecimento savedEntity = abastecimentoRepository.save(entity);

        return new AbastecimentoResponse(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<AbastecimentoResponse> getAll() {
        return abastecimentoRepository.findAll()
                .stream()
                .map(AbastecimentoResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AbastecimentoResponse getById(Long id) {
        Abastecimento entity = abastecimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abastecimento não encontrado com ID: " + id));
        return new AbastecimentoResponse(entity);
    }

    @Transactional
    public AbastecimentoResponse update(Long id, AbastecimentoRequest request) {
        Abastecimento entity = abastecimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abastecimento não encontrado com ID: " + id));

        BombaCombustivel bomba = bombaRepository.findById(request.bombaId())
                .orElseThrow(() -> new ResourceNotFoundException("Bomba não encontrada com ID: " + request.bombaId()));

        BigDecimal precoPorLitro = bomba.getTipoCombustivel().getPrecoPorLitro();
        BigDecimal valorTotal = request.valorTotalAbastecido();
        BigDecimal litragem = valorTotal.divide(precoPorLitro, 3, RoundingMode.HALF_UP);

        entity.setBomba(bomba);
        entity.setValorTotal(valorTotal);
        entity.setLitragem(litragem);

        Abastecimento updatedEntity = abastecimentoRepository.save(entity);
        return new AbastecimentoResponse(updatedEntity);
    }

    @Transactional
    public void delete(Long id) {
        if (!abastecimentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Abastecimento não encontrado com ID: " + id);
        }
        abastecimentoRepository.deleteById(id);
    }
}
