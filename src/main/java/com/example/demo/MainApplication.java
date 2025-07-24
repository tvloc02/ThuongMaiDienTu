package com.example.demo;

import com.example.demo.component.IT4Greeting;
import com.example.demo.service.TinhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Lớp chính của ứng dụng Spring Boot
 * Câu 1: Spring Boot Console với CommandLineRunner
 * Câu 2: Bật tính năng AOP với @EnableAspectJAutoProxy
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class MainApplication implements CommandLineRunner {

    // Câu 1: Inject IT4Greeting để sử dụng DI
    private final IT4Greeting it4Greeting;

    // Câu 2: Inject TinhToanService để test AOP
    private final TinhToanService tinhToanService;

    /**
     * Constructor injection
     * @param it4Greeting component sử dụng GreetingService
     * @param tinhToanService service tính toán với AOP
     */
    @Autowired
    public MainApplication(IT4Greeting it4Greeting, TinhToanService tinhToanService) {
        this.it4Greeting = it4Greeting;
        this.tinhToanService = tinhToanService;
    }

    /**
     * Phương thức main để khởi động ứng dụng
     * @param args tham số dòng lệnh
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    /**
     * Phương thức được gọi sau khi Spring Boot khởi động
     * Câu 1: Gọi phương thức in lời chào
     * Câu 2: Gọi phương thức cộng để test AOP
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== SPRING BOOT EXAM - BẮT ĐẦU ===");

        // Câu 1: Test Dependency Injection
        System.out.println("\n--- Câu 1: Test Dependency Injection ---");
        it4Greeting.showGreeting();

        // Câu 2: Test AOP
        System.out.println("\n--- Câu 2: Test AOP ---");
        int ketQua = tinhToanService.cong(2, 3);
        System.out.println("Kết quả phép cộng 2 + 3 = " + ketQua);

        System.out.println("\n=== SPRING BOOT EXAM - KẾT THÚC ===");
        System.out.println("Web API đã sẵn sàng tại: http://localhost:8081/api/giaodich");
        System.out.println("Swagger UI: http://localhost:8081/swagger-ui.html");
    }
}