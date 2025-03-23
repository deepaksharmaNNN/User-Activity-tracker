package org.deepaksharma.trackingservice.repository;

import org.deepaksharma.trackingservice.model.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}
