package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller jo Student Management API requests ko handle karta hai.
 * Base Endpoint URL: /api/v1/students
 */
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    /**
     * POST /api/v1/students - Naya student add karne ke liye REST endpoint
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    /**
     * GET /api/v1/students - Saare students ki list fetch karne ke liye endpoint
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/v1/students/{id} - Single student ki details ID dwara lane ke liye endpoint
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    /**
     * GET /api/v1/students/department/{department} - Department ke anusar filter karne ke liye endpoint
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Student>> getStudentsByDepartment(@PathVariable String department) {
        List<Student> students = studentService.getStudentsByDepartment(department);
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/v1/students/gpa?minGpa=3.5 - Minimum GPA ke anusar filter karne ke liye endpoint
     */
    @GetMapping("/gpa")
    public ResponseEntity<List<Student>> getStudentsByMinGpa(@RequestParam(defaultValue = "0.0") Double minGpa) {
        List<Student> students = studentService.getStudentsByMinGpa(minGpa);
        return ResponseEntity.ok(students);
    }

    /**
     * PUT /api/v1/students/{id} - Student details update karne ke liye endpoint
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String id, 
            @Valid @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * DELETE /api/v1/students/{id} - Student ID dwara delete karne ke liye endpoint
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student record kamyabi se delete ho gaya!");
        response.put("studentId", id);
        return ResponseEntity.ok(response);
    }
}
