package com.posto.dto;

import com.posto.model.Abastecimento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AbastecimentoResponse(
        Long id,
        LocalDateTime dataAbastecimento,
        BigDecimal valorTotal,
        BigDecimal litragem,
        String nomeBomba
) {
    public AbastecimentoResponse(Abastecimento entity) {
        this(
                entity.getId(),
                entity.getDataAbastecimento(),
                entity.getValorTotal(),
                entity.getLitragem(),
                entity.getBomba().getNome()
        );
    }
}