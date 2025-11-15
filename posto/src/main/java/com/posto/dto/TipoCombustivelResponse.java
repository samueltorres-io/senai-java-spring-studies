package com.posto.dto;

import com.posto.model.TipoCombustivel;
import java.math.BigDecimal;

public record TipoCombustivelResponse(
        Long id,
        String nome,
        BigDecimal precoPorLitro
) {
    public TipoCombustivelResponse(TipoCombustivel entity) {
        this(entity.getId(), entity.getNome(), entity.getPrecoPorLitro());
    }
}