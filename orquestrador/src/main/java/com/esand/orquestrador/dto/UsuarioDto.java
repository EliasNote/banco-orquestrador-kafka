package com.esand.orquestrador.dto;

import lombok.Builder;

@Builder
public record UsuarioDto(
        Long id,
        String nome,
        String cpf,
        String genero
) {
}
