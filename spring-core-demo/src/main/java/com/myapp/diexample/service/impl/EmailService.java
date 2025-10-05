package com.myapp.diexample.service.impl;

import com.myapp.diexample.service.NotificationService;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Email send to " + recipient + " with message : " + message);
    }
}
