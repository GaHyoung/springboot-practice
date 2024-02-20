package com.nhnacademy.edu.springboot.student.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private final AtomicBoolean healty = new AtomicBoolean(true);

    public void setUnhealthy(){
        this.healty.set(false);
    }

    @Override
    public Health health() {
        if(healty.get()){
            return Health.up().build();
        }
        healty.set(false);
        return Health.down().build();
    }
}
