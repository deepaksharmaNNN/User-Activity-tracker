package org.deepaksharma.analyticsservice.repository;

import org.deepaksharma.analyticsservice.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
    List<TrackingEvent> findByProductId(String productId);
}
