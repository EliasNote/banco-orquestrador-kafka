package com.esand.orquestrador.controller;

import com.esand.orquestrador.dto.EventDto;
import com.esand.orquestrador.service.OrchestratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/start")
public class OrquestratorController {

    private final OrchestratorService orchestratorService;

    @PostMapping
    public ResponseEntity<Void> start(@RequestBody EventDto event) {
        orchestratorService.start(event);
        return ResponseEntity.noContent().build();
    }
}
