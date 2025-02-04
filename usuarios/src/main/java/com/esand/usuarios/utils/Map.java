package com.esand.usuarios.utils;

import com.esand.usuarios.dto.UsuarioDto;
import com.esand.usuarios.entity.Usuario;

public class Map {

    public static Usuario toUsuario(UsuarioDto dto) {
        return Usuario.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .genero(Usuario.Genero.valueOf(dto.genero()))
                .build();
    }

    public static UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .genero(usuario.getGenero().toString())
                .build();
    }
}
