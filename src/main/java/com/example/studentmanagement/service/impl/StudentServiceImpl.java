package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.exception.DuplicateResourceException;
import com.example.studentmanagement.exception.ResourceNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation handling business logic for Student entity operations.
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        // Business Rule: Check if email already exists
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateResourceException(
                    "Student with email '" + student.getEmail() + "' already exists!"
            );
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @Override
    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartmentIgnoreCase(department);
    }

    @Override
    public List<Student> getStudentsByMinGpa(Double minGpa) {
        return studentRepository.findByGpaGreaterThanEqual(minGpa);
    }

    @Override
    public Student updateStudent(String id, Student studentDetails) {
        Student existingStudent = getStudentById(id);

        // If email is changing, ensure new email is not already taken
        if (!existingStudent.getEmail().equalsIgnoreCase(studentDetails.getEmail()) 
                && studentRepository.existsByEmail(studentDetails.getEmail())) {
            throw new DuplicateResourceException(
                    "Email '" + studentDetails.getEmail() + "' is already in use by another student!"
            );
        }

        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setDepartment(studentDetails.getDepartment());
        existingStudent.setGpa(studentDetails.getGpa());
        existingStudent.setEnrolledCourses(studentDetails.getEnrolledCourses());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }
}
