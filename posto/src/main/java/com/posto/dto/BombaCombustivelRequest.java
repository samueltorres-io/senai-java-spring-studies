package com.posto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BombaCombustivelRequest(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull(message = "O ID do tipo de combustível é obrigatório")
        Long tipoCombustivelId
) {
}