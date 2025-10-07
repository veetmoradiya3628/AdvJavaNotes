package com.example.spring_aop_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_aop_demo.service.PaymentService;

@RestController
public class HelloController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/test")
	public String testEndpoint() {
		paymentService.processPayment();
		return "test endpoint called!!!";
	}

    @GetMapping("/timeconsume")
    public String timeConsumeAPI() throws InterruptedException {
        paymentService.timeConsume();
        return "Time consume called";
    }
}