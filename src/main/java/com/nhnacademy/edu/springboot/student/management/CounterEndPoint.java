package com.nhnacademy.edu.springboot.student.management;

import io.micrometer.core.lang.Nullable;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Endpoint(id="counter")
public class CounterEndPoint {
    private final AtomicLong count = new AtomicLong();

    @ReadOperation
    public Long read(){
        return count.get();
    }

    @WriteOperation
    public Long increament(@Nullable Long delta){
        return count.addAndGet(delta);
    }

    @DeleteOperation
    public Long delete(){
        count.set(0);
        return count.get();
    }
}
