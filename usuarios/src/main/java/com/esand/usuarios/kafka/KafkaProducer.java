package com.esand.usuarios.kafka;

import com.esand.usuarios.dto.EventDto;
import com.esand.usuarios.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final JsonUtil jsonUtil;

    public void sendEvent(EventDto event, String topic) {
        try {
            log.info("Sending event to topic {} with data {}", topic, event);
            kafkaTemplate.send(topic, jsonUtil.toJson(event));
        } catch (Exception e) {
            log.error("Error trying to send data to topic {} with data {}", topic, event, e);
        }
    }
}
