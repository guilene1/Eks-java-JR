package com.jobready.orders;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Value("${APP_ENV:local}")
    private String environment;

    @GetMapping("/orders")
    public List<Map<String, Object>> orders() {
        return List.of(
            Map.of("id", 1001, "item", "Laptop", "status", "SHIPPED"),
            Map.of("id", 1002, "item", "Monitor", "status", "PROCESSING"),
            Map.of("id", 1003, "item", "Keyboard", "status", "DELIVERED")
        );
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        return Map.of(
            "service", "orders-api",
            "environment", environment,
            "timestamp", Instant.now().toString()
        );
    }
}
