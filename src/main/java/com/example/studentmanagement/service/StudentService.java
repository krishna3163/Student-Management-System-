package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;

import java.util.List;

/**
 * Service interface jo Student management business methods define karta hai.
 */
public interface StudentService {

    /**
     * Naya student record database me save karne ke liye.
     */
    Student createStudent(Student student);

    /**
     * Database me se saare students ki list fetch karne ke liye.
     */
    List<Student> getAllStudents();

    /**
     * Unique ID se single student ki detail search karne ke liye.
     */
    Student getStudentById(String id);

    /**
     * Department wise students search karne ke liye.
     */
    List<Student> getStudentsByDepartment(String department);

    /**
     * Minimum GPA ke basis par top students filter karne ke liye.
     */
    List<Student> getStudentsByMinGpa(Double minGpa);

    /**
     * Existing student ki details ID dwara update karne ke liye.
     */
    Student updateStudent(String id, Student studentDetails);

    /**
     * Student record ko database se remove karne ke liye.
     */
    void deleteStudent(String id);
}
