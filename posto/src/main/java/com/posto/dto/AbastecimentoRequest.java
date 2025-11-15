package com.posto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record AbastecimentoRequest(
        @NotNull(message = "O ID da bomba é obrigatório")
        Long bombaId,

        @NotNull(message = "O valor a ser abastecido é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valorTotalAbastecido
) {
}
