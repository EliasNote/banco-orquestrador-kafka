package com.esand.orquestrador.config.kafka.topic;

import org.springframework.beans.factory.annotation.Value;

public class Topics {

    @Value("${spring.kafka.topic.usuarios}")
    private static String usuariosTopic;

    @Value("${spring.kafka.topic.contas}")
    private static String contasTopic;

    @Value("${spring.kafka.topic.orchestrator}")
    private static String orchestratorTopic;

    public static String getUsuarios() {
        return usuariosTopic;
    }

    public static String getContas() {
        return contasTopic;
    }

    public static String getOrchestrator() {
        return orchestratorTopic;
    }
}
