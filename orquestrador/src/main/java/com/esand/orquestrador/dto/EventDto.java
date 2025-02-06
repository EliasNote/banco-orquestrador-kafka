package com.esand.orquestrador.dto;

import lombok.Builder;

@Builder
public record EventDto(
        UsuarioDto usuario,
        ContaDto conta
) {
}
