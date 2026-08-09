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
 * REST Controller providing API endpoints for Student Management operations.
 * Base Endpoint: /api/v1/students
 */
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    /**
     * POST /api/v1/students - Create a new student
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    /**
     * GET /api/v1/students - Retrieve all students
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/v1/students/{id} - Retrieve student by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    /**
     * GET /api/v1/students/department/{department} - Filter students by department
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Student>> getStudentsByDepartment(@PathVariable String department) {
        List<Student> students = studentService.getStudentsByDepartment(department);
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/v1/students/gpa?minGpa=3.5 - Filter students by minimum GPA
     */
    @GetMapping("/gpa")
    public ResponseEntity<List<Student>> getStudentsByMinGpa(@RequestParam(defaultValue = "0.0") Double minGpa) {
        List<Student> students = studentService.getStudentsByMinGpa(minGpa);
        return ResponseEntity.ok(students);
    }

    /**
     * PUT /api/v1/students/{id} - Update an existing student
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String id, 
            @Valid @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * DELETE /api/v1/students/{id} - Delete student by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student deleted successfully!");
        response.put("studentId", id);
        return ResponseEntity.ok(response);
    }
}
