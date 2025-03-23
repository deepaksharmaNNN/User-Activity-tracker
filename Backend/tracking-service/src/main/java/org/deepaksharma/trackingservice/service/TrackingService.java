package org.deepaksharma.trackingservice.service;

import lombok.RequiredArgsConstructor;
import org.deepaksharma.trackingservice.model.TrackingEvent;
import org.deepaksharma.trackingservice.repository.TrackingEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TrackingService {
    private final TrackingEventRepository trackingEventRepository;

    public void trackEvent(String eventType, String productId) {
        TrackingEvent trackingEvent = TrackingEvent.builder()
                .eventType(eventType)
                .productId(productId)
                .timestamp(LocalDateTime.now())
                .build();
        trackingEventRepository.save(trackingEvent);
    }
}
