package com.esand.contas.dto;

import lombok.Builder;

@Builder
public record ContaDto(
        Long usuarioId,

        Double saldo,

        String tipo
) {
}
