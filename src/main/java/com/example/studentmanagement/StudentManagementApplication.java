package com.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Student Management System application ka main entry point.
 * 
 * @SpringBootApplication Spring Boot app start karta hai,
 * auto-configuration enable karta hai aur components ko scan karta hai.
 */
@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
        System.out.println("\n---------------------------------------------------------");
        System.out.println("🚀 Student Management System REST API start ho gayi hai!");
        System.out.println("📍 Base URL: http://localhost:8080/api/v1/students");
        System.out.println("---------------------------------------------------------\n");
    }
}
