package org.deepaksharma.analyticsservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumer {

    @KafkaListener(topics = "tracking-events", groupId = "tracking-consumer-group")
    public void consume(String message) {
        log.info("Consumed message: {}", message);
    }

}
