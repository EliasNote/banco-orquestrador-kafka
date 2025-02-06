package com.esand.usuarios.kafka;

import com.esand.usuarios.service.UsuarioService;
import com.esand.usuarios.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private final UsuarioService usuarioService;
    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.usuarios}"
    )
    public void consumerStart(String payload) {
        log.info("Receiving event {} from start topic", payload);
        usuarioService.sendEvent(jsonUtil.toEvent(payload));
    }
}
