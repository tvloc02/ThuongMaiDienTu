package com.example.demo.service;

import org.springframework.stereotype.Component;

/**
 * Lớp cài đặt interface TinhToanService
 * Được đánh dấu là @Component để Spring quản lý
 */
@Component
public class K2TinhToanService implements TinhToanService {

    @Override
    public int cong(int a, int b) {
        return a + b;
    }
}