package com.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Student Management System application.
 * 
 * @SpringBootApplication marks this class as a Spring Boot application,
 * enabling auto-configuration, component scanning, and extra configuration.
 */
@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
        System.out.println("\n---------------------------------------------------------");
        System.out.println("🚀 Student Management System REST API is up and running!");
        System.out.println("📍 Base URL: http://localhost:8080/api/v1/students");
        System.out.println("---------------------------------------------------------\n");
    }
}
