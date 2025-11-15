package com.posto.dto;

import com.posto.model.BombaCombustivel;

public record BombaCombustivelResponse(
        Long id,
        String nome,
        TipoCombustivelResponse tipoCombustivel
) {
    public BombaCombustivelResponse(BombaCombustivel entity) {
        this(
                entity.getId(),
                entity.getNome(),
                new TipoCombustivelResponse(entity.getTipoCombustivel())
        );
    }
}
