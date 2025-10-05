package com.myapp.diexample.client;

import com.myapp.diexample.service.NotificationService;

public class UserController {
    private final NotificationService notificationService;

    public UserController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void processUser(String user) {
        System.out.println("Processing user: " + user);
        notificationService.sendNotification("Welcome " + user + "!", user);
    }
}
