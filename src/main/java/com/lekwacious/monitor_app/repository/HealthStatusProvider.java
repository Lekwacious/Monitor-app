package com.lekwacious.monitor_app.repository;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class HealthStatusProvider  {

    private final HealthEndpoint healthEndpoint;
    private final MetricsEndpoint metricsEndpoint;

    public HealthStatusProvider(HealthEndpoint healthEndpoint, MetricsEndpoint metricsEndpoint) {
        this.healthEndpoint = healthEndpoint;
        this.metricsEndpoint = metricsEndpoint;
    }

    public Status getHealthStatus() {
        return this.healthEndpoint.health().getStatus();
    }

    public Set<String> getMetricsEndpoint() {
        return metricsEndpoint.listNames().getNames();
    }
}
