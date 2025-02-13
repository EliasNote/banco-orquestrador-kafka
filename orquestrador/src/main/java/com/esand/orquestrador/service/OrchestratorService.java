package com.esand.orquestrador.service;

import com.esand.orquestrador.config.kafka.topic.Topics;
import com.esand.orquestrador.dto.EventDto;
import com.esand.orquestrador.enums.Source;
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

    public void start(EventDto event) {
        kafkaProducer.sendEvent(
                event,
                topics.getOrchestratorTopic()
        );
    }

    public void sendEvent(EventDto event) {
        System.out.println("\n\n\n" + event.source() + "\n\n\n");
        kafkaProducer.sendEvent(
                event,
                nextTopic(event.source())
        );
    }

    public String nextTopic(Source topic) {
        if (topic == null) {
            return topics.getUsuariosTopic();
        }
        if (topic == Source.USUARIOS) {
            return topics.getContasTopic();
        }
        return null;
    }
}
