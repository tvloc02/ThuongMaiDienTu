package com.example.demo.component;

import com.example.demo.service.GreetingService;
import org.springframework.stereotype.Component;

/**
 * Lớp sử dụng dịch vụ GreetingService thông qua Dependency Injection
 */
@Component
public class IT4Greeting {

    private final GreetingService greetingService;

    /**
     * Constructor injection - cách ưu tiên để inject dependency
     * @param greetingService service được inject
     */
    public IT4Greeting(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * Phương thức in ra lời chào từ service
     */
    public void showGreeting() {
        System.out.println("IT4Greeting: " + greetingService.getGreeting());
    }
}