package com.esand.orquestrador.service;

import com.esand.orquestrador.config.kafka.topic.Topics;
import com.esand.orquestrador.dto.UsuarioDto;
import com.esand.orquestrador.dto.EventDto;
import com.esand.orquestrador.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class OrchestratorService {

    private final KafkaProducer kafkaProducer;
    private final Topics topics;

    public void sendEvent(UsuarioDto usuario) {
        kafkaProducer.sendEvent(EventDto.builder().usuario(usuario).build(), topics.getUsuariosTopic());
    }
}
