package com.esand.usuarios.dto;

import lombok.Builder;

@Builder
public record EventDto(
        UsuarioDto usuario,
        ContaDto conta
) {
}
