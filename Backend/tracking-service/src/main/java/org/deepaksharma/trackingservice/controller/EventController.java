package org.deepaksharma.trackingservice.controller;

import lombok.RequiredArgsConstructor;
import org.deepaksharma.trackingservice.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    private final TrackingService trackingService;

    @PostMapping("/click") // http://localhost:8081/api/v1/event/click?productId=123
    public ResponseEntity<?> trackClick(@RequestParam String productId) {
        trackingService.trackEvent("Click", productId);
        return ResponseEntity.ok("Click event tracked " + productId);
    }
    @PostMapping("/add_to_cart")
    public String trackAddToCart(@RequestParam String productId) {
        trackingService.trackEvent("Add_to_cart", productId);
        return "Add_to_cart event tracked " + productId;
    }
    @PostMapping("/remove_from_cart")
    public String trackRemoveFromCart(@RequestParam String productId) {
        trackingService.trackEvent("Remove_from_cart", productId);
        return "Remove_from_cart event tracked " + productId;
    }
}
