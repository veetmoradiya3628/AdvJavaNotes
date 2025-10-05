package com.myapp.diexample;

import com.myapp.diexample.client.UserController;
import com.myapp.diexample.service.NotificationService;
import com.myapp.diexample.service.impl.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public NotificationService emailService() {
        return new EmailService();
    }

    @Bean
    public UserController userController() {
        return new UserController(emailService()); // Inject dependency
    }
}
