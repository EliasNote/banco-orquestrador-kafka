package com.esand.usuarios.controller;

import com.esand.usuarios.dto.UsuarioDto;
import com.esand.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto dto) {
        return ResponseEntity.status(201).body(usuarioService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
}
