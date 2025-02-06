package com.esand.usuarios.dto;

import lombok.Builder;

@Builder
public record ContaDto(
        Long usuarioId,
        Double saldo,
        String tipo
) {
}
