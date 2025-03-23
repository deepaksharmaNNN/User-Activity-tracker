package org.deepaksharma.analyticsservice.controller;

import lombok.RequiredArgsConstructor;
import org.deepaksharma.analyticsservice.entity.TrackingEvent;
import org.deepaksharma.analyticsservice.repository.TrackingEventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final TrackingEventRepository trackingEventRepository;

    @GetMapping("/events")
    public List<TrackingEvent> getEvents() {
        return trackingEventRepository.findAll();
    }

    @GetMapping("/events/{productId}")
    public List<TrackingEvent> getEventsByProductId(@PathVariable String productId) {
        return trackingEventRepository.findByProductId(productId);
    }
}
