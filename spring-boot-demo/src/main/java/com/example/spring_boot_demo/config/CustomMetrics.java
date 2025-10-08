package com.example.spring_boot_demo.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {
    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void incrementGetUserCalls() {
        meterRegistry.counter("custom.get_user.calls").increment();
    }
}
