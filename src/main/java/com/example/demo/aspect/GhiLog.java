package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Lớp xử lý AOP để ghi log
 */
@Aspect
@Component
public class GhiLog {

    /**
     * Advice được thực hiện sau khi phương thức cong() được gọi
     * Sử dụng @After để ghi log sau khi phương thức thực hiện xong
     */
    @After("execution(* com.example.demo.service.TinhToanService.cong(..))")
    public void logAfterCong() {
        System.out.println("AOP Log: Phép cộng đã được thực hiện");
    }
}