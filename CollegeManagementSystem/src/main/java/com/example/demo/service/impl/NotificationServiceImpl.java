package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Notification;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getById(Long id) throws ResourceNotFoundException {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with ID: " + id));
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification update(Long id, Notification notification) throws ResourceNotFoundException {
        Notification existingNotification = getById(id);
        existingNotification.setMessage(notification.getMessage()); // Update other fields
        return notificationRepository.save(existingNotification);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Notification existingNotification = getById(id);
        notificationRepository.delete(existingNotification);
    }
}
