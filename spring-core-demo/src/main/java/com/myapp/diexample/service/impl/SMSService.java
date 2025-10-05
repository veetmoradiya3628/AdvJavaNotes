package com.myapp.diexample.service.impl;

import com.myapp.diexample.service.NotificationService;

public class SMSService implements NotificationService {

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + " with message : " + message);
    }
}
