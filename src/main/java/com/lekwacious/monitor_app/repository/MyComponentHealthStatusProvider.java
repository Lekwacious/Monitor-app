package com.lekwacious.monitor_app.repository;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MyComponentHealthStatusProvider {
    private final List<HealthIndicator> healthIndicators;
    private final MetricsEndpoint metricsEndpoint;

    public MyComponentHealthStatusProvider(List<HealthIndicator> healthIndicators, MetricsEndpoint metricsEndpoint) {
        this.healthIndicators = healthIndicators;
        this.metricsEndpoint = metricsEndpoint;
    }

    public Health getHealthStatus() {
        return this.healthIndicators.get(0).getHealth(true);
    }
    public Set<String> getMetricsEndpoint() {
        return metricsEndpoint.listNames().getNames();
    }
}
