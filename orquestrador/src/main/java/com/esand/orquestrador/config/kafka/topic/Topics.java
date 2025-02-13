package com.esand.orquestrador.config.kafka.topic;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Topics {

    @Value("${spring.kafka.topic.start}")
    private String startTopic;

    @Value("${spring.kafka.topic.usuarios}")
    private String usuariosTopic;

    @Value("${spring.kafka.topic.contas}")
    private String contasTopic;

    @Value("${spring.kafka.topic.orchestrator}")
    private String orchestratorTopic;
}