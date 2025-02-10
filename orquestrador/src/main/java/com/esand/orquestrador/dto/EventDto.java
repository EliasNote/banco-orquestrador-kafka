package com.esand.orquestrador.dto;

import com.esand.orquestrador.enums.Source;
import lombok.Builder;

@Builder
public record EventDto(
        Source source,
        UsuarioDto usuario,
        ContaDto conta
) {
}
