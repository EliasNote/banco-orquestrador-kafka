package com.esand.orquestrador.kafka;

import com.esand.orquestrador.dto.EventDto;
import com.esand.orquestrador.utils.JsonUtil;
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

    public void sendEvent(EventDto eventDto, String topic) {
        try {
            log.info("Sending event to topic {} with data {}", topic, eventDto);
            kafkaTemplate.send(topic, jsonUtil.toJson(eventDto));
        } catch (Exception e) {
            log.error("Error trying to send data to topic {} with data {}", topic, eventDto, e);
        }
    }
}
