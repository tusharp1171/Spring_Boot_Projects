package com.example.demo.service;

import com.example.demo.model.Notification;
import java.util.List;

public interface NotificationService {
    Notification createNotification(Notification notification);
    Notification getById(Long id);
    List<Notification> getAll();
    Notification update(Long id, Notification notification);
    void delete(Long id);
}