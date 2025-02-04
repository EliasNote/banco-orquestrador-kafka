package com.esand.usuarios.service;

import com.esand.usuarios.dto.UsuarioDto;
import com.esand.usuarios.repository.UsuarioRepository;
import com.esand.usuarios.utils.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.esand.usuarios.utils.Map.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDto cadastrar(UsuarioDto dto) {
        return toDto(usuarioRepository.save(toUsuario(dto)));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> buscarTodos() {
        return usuarioRepository.findAll().stream().map(Map::toDto).toList();
    }
}
