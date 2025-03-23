package org.deepaksharma.analyticsservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deepaksharma.analyticsservice.entity.TrackingEvent;
import org.deepaksharma.analyticsservice.repository.TrackingEventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventConsumer {

    private final TrackingEventRepository trackingEventRepository;
    private final AnalyticsMetricsService analyticsMetricsService;

    @KafkaListener(topics = "tracking-events", groupId = "tracking-consumer-group")
    public void consume(String message) {
        log.info("Consumed message: {}", message);

        String[] parts = message.split(":");
        if (parts.length < 2) {
            log.warn("Invalid message format: {}. Expected format: 'part1:part2'", message);
            return;
        }

        TrackingEvent event = new TrackingEvent(null, parts[0], parts[1], LocalDateTime.now());
        log.debug("Saving event: {}", event);
        trackingEventRepository.save(event);
        log.info("Event saved successfully: {}", event);
        // Increment the event count metric
        analyticsMetricsService.incrementEventCount(parts[0]);
    }

}
