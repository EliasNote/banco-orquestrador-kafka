package com.esand.orquestrador.kafka;

import com.esand.orquestrador.service.OrchestratorService;
import com.esand.orquestrador.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private final OrchestratorService orchestratorService;
    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.orchestrator}"
    )
    public void consumer(String payload) {
        log.info("Receiving event {} from start topic", payload);
        orchestratorService.sendEvent(jsonUtil.toEvent(payload));
    }
}
