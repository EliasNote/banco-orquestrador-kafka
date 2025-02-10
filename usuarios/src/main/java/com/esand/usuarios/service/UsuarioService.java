package com.esand.usuarios.service;

import com.esand.usuarios.dto.EventDto;
import com.esand.usuarios.dto.UsuarioDto;
import com.esand.usuarios.enums.Source;
import com.esand.usuarios.kafka.KafkaProducer;
import com.esand.usuarios.repository.UsuarioRepository;
import com.esand.usuarios.utils.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.esand.usuarios.utils.Map.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Value("${spring.kafka.topic.orchestrator}")
    private String orchestratorTopic;

    private final UsuarioRepository usuarioRepository;
    private final KafkaProducer kafkaProducer;

    public void sendEvent(EventDto event) {
        UsuarioDto usuario = cadastrar(event.usuario());
        kafkaProducer.sendEvent(
                EventDto.builder()
                        .source(Source.USUARIOS)
                        .usuario(usuario)
                        .build(),
                orchestratorTopic
        );
    }

    @Transactional
    public UsuarioDto cadastrar(UsuarioDto dto) {
        return toDto(usuarioRepository.save(toUsuario(dto)));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> buscarTodos() {
        return usuarioRepository.findAll().stream().map(Map::toDto).toList();
    }
}