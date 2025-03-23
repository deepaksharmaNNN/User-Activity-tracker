package org.deepaksharma.analyticsservice.service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsMetricsService {
    private final MeterRegistry meterRegistry;

    public void incrementEventCount(String eventType) {
        meterRegistry.counter("analytics.event.count", "type", eventType).increment();
    }
}
