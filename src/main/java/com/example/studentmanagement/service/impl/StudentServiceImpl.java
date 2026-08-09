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
 * Service Implementation class jo saare business logic aur database operations handle karti hai.
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        // Business Rule: Check karo agar email pehle se exist karti hai
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateResourceException(
                    "Student email '" + student.getEmail() + "' pehle se exist karti hai!"
            );
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        // Database se saare student records fetch karo
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        // ID se student find karo, agar nahi mile toh custom exception throw karo
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @Override
    public List<Student> getStudentsByDepartment(String department) {
        // Department name se search karo (case-insensitive)
        return studentRepository.findByDepartmentIgnoreCase(department);
    }

    @Override
    public List<Student> getStudentsByMinGpa(Double minGpa) {
        // Minimum GPA threshold ke basis par filter karo
        return studentRepository.findByGpaGreaterThanEqual(minGpa);
    }

    @Override
    public Student updateStudent(String id, Student studentDetails) {
        // Pehle check karo ki student record database me hai ya nahi
        Student existingStudent = getStudentById(id);

        // Agar email change ho raha hai, toh verify karo ki naya email kisi aur student ke paas toh nahi hai
        if (!existingStudent.getEmail().equalsIgnoreCase(studentDetails.getEmail()) 
                && studentRepository.existsByEmail(studentDetails.getEmail())) {
            throw new DuplicateResourceException(
                    "Email '" + studentDetails.getEmail() + "' kisi aur student dwara pehle se registered hai!"
            );
        }

        // Student ki details update karo
        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setDepartment(studentDetails.getDepartment());
        existingStudent.setGpa(studentDetails.getGpa());
        existingStudent.setEnrolledCourses(studentDetails.getEnrolledCourses());

        // Updated record save karo
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        // Student exist karta hai ya nahi check karke delete karo
        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }
}
