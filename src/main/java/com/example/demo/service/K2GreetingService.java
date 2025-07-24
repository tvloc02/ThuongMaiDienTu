package com.example.demo.service;

import org.springframework.stereotype.Component;

/**
 * Lớp cài đặt interface GreetingService
 * Được đánh dấu là @Component để Spring quản lý
 */
@Component
public class K2GreetingService implements GreetingService {

    @Override
    public String getGreeting() {
        return "Xin chào từ K2!";
    }
}