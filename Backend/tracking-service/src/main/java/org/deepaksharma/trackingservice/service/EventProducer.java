package org.deepaksharma.trackingservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepaksharma.trackingservice.model.TrackingEvent;
import org.deepaksharma.trackingservice.repository.TrackingEventRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "tracking-events";
    private final TrackingEventRepository trackingEventRepository;

    public void sendEvent(String eventType, String productId) {
        String message = eventType + ":" + productId;
        log.info("Producing message: {}", message);
        kafkaTemplate.send(TOPIC, message);
    }

}