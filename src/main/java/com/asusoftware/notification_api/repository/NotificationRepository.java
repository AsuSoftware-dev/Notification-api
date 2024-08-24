package com.asusoftware.notification_api.repository;

import com.asusoftware.notification_api.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findByRecipientId(UUID recipientId);
    // Metodă pentru a obține notificările legate de un anumit Place
    List<Notification> findByRelatedPlaceId(UUID relatedPlaceId);
}
