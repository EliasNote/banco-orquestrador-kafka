package com.esand.orquestrador.kafka;

import com.esand.orquestrador.service.OrchestratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private final OrchestratorService orchestratorService;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.start}"
    )
    public void consumerStart(String text) {
        log.info("Receiving event {} from start topic", text);
        orchestratorService.sendEvent("teste asdasdasdas");
    }
}
