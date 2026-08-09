package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * MongoDB Repository interface for Student operations.
 * MongoRepository extend karke saare basic CRUD methods automatic mil jaate hain.
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    /**
     * Unique email se student search karne ke liye custom query method.
     */
    Optional<Student> findByEmail(String email);

    /**
     * Particular department ke saare students list karne ke liye method.
     */
    List<Student> findByDepartmentIgnoreCase(String department);

    /**
     * Check karne ke liye ki given email se koi student pehle se exist karta hai ya nahi.
     */
    boolean existsByEmail(String email);

    /**
     * Given minimum GPA se barabar ya uper ke students fetch karne ke liye method.
     */
    List<Student> findByGpaGreaterThanEqual(Double gpa);
}
