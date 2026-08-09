package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Student document operations in MongoDB.
 * Extends MongoRepository to gain standard CRUD and pagination methods out-of-the-box.
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    /**
     * Find a student by unique email address.
     */
    Optional<Student> findByEmail(String email);

    /**
     * Find all students belonging to a specific department.
     */
    List<Student> findByDepartmentIgnoreCase(String department);

    /**
     * Check if a student with given email already exists.
     */
    boolean existsByEmail(String email);

    /**
     * Find students with a GPA higher than or equal to a specified value.
     */
    List<Student> findByGpaGreaterThanEqual(Double gpa);
}
