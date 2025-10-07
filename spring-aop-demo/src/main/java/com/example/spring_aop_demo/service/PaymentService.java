package com.example.spring_aop_demo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	public void processPayment() {
		System.out.println("Processing payment...");
	}

    public void timeConsume() throws InterruptedException {
        Thread.sleep(3000);
    }
}
