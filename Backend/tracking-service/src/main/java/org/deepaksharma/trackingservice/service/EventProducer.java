package org.deepaksharma.trackingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "tracking-events";

    public void sendEvent(String eventType, String productId) {
        kafkaTemplate.send(TOPIC, eventType + " " + productId);
    }

}