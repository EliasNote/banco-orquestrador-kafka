package com.esand.usuarios.dto;

import com.esand.usuarios.enums.Source;
import lombok.Builder;

@Builder
public record EventDto(
        Source source,
        UsuarioDto usuario,
        ContaDto conta
) {
}
