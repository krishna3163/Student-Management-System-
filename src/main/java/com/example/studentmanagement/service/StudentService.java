package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;

import java.util.List;

/**
 * Service Interface defining business contracts for Student operations.
 */
public interface StudentService {

    /**
     * Create and save a new student record.
     */
    Student createStudent(Student student);

    /**
     * Retrieve all students from the database.
     */
    List<Student> getAllStudents();

    /**
     * Retrieve a single student by unique ID.
     */
    Student getStudentById(String id);

    /**
     * Retrieve students filtered by department.
     */
    List<Student> getStudentsByDepartment(String department);

    /**
     * Retrieve students with GPA >= minimum GPA threshold.
     */
    List<Student> getStudentsByMinGpa(Double minGpa);

    /**
     * Update an existing student's details by ID.
     */
    Student updateStudent(String id, Student studentDetails);

    /**
     * Delete a student by ID.
     */
    void deleteStudent(String id);
}
