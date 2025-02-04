package com.esand.contas.controller;

import com.esand.contas.dto.ContaDto;
import com.esand.contas.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDto> cadastrar(@RequestBody ContaDto dto) {
        return ResponseEntity.status(201).body(contaService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContaDto>> buscarTodas() {
        return ResponseEntity.ok(contaService.buscarTodas());
    }
}
