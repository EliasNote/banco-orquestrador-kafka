package com.esand.usuarios.dto;

import com.esand.usuarios.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

@Builder
public record UsuarioDto(

        @JsonIgnore
        Long id,

        String nome,

        @CPF
        String cpf,

        String genero
) {
}
