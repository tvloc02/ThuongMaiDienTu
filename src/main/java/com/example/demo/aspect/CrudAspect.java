package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Câu 5: Vận dụng AOP vào Web API actions
 * Aspect class để ghi log cho các thao tác CRUD
 */
@Aspect
@Component
public class CrudAspect {

    /**
     * Ghi log trước khi thực hiện các phương thức trong GiaoDichController
     */
    @Before("execution(* com.example.demo.controller.GiaoDichController.*(..))")
    public void logBeforeCrudOperation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AOP CRUD Log: Bắt đầu thực hiện " + methodName);
    }

    /**
     * Ghi log sau khi thực hiện các phương thức trong GiaoDichController
     */
    @After("execution(* com.example.demo.controller.GiaoDichController.*(..))")
    public void logAfterCrudOperation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AOP CRUD Log: Đã hoàn thành " + methodName);
    }

    /**
     * Ghi log cụ thể cho thao tác CREATE
     */
    @After("execution(* com.example.demo.controller.GiaoDichController.createGiaoDich(..))")
    public void logAfterCreate() {
        System.out.println("AOP CRUD Log: Đã tạo giao dịch mới");
    }

    /**
     * Ghi log cụ thể cho thao tác READ
     */
    @After("execution(* com.example.demo.controller.GiaoDichController.getGiaoDichById(..))")
    public void logAfterRead() {
        System.out.println("AOP CRUD Log: Đã truy xuất thông tin giao dịch");
    }

    /**
     * Ghi log cụ thể cho thao tác UPDATE
     */
    @After("execution(* com.example.demo.controller.GiaoDichController.updateGiaoDich(..))")
    public void logAfterUpdate() {
        System.out.println("AOP CRUD Log: Đã cập nhật giao dịch");
    }

    /**
     * Ghi log cụ thể cho thao tác DELETE
     */
    @After("execution(* com.example.demo.controller.GiaoDichController.deleteGiaoDich(..))")
    public void logAfterDelete() {
        System.out.println("AOP CRUD Log: Đã xóa giao dịch");
    }
}