package com.example.studentmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * MongoDB Document representation for Student entity.
 * MongoDB collection name: 'students'
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "students")
public class Student {

    @Id
    private String id; // MongoDB dwara generate ki gayi unique String ID

    @NotBlank(message = "First name mandatory hai, khali nahi ho sakta")
    private String firstName; // Student ka first name (e.g. Aarav, Rahul)

    @NotBlank(message = "Last name mandatory hai, khali nahi ho sakta")
    private String lastName; // Student ka last name (e.g. Sharma, Verma)

    @NotBlank(message = "Email address mandatory hai")
    @Email(message = "Valid email address enter karein")
    @Indexed(unique = true)
    private String email; // Student ki unique email ID (e.g. aarav.sharma@college.ac.in)

    @NotBlank(message = "Department mandatory hai")
    private String department; // Department (e.g. Computer Science, Information Technology)

    @NotNull(message = "GPA mandatory hai")
    @Min(value = 0, message = "GPA 0.0 se kam nahi ho sakta")
    @Max(value = 4, message = "GPA 4.0 se zyada nahi ho sakta")
    private Double gpa; // Student ka GPA (0.0 - 4.0)

    private List<String> enrolledCourses; // Enrolled subjects ki list (e.g. Java, DBMS, Web Tech)

    @CreatedDate
    private LocalDateTime createdAt; // Record create hone ka timestamp

    @LastModifiedDate
    private LocalDateTime updatedAt; // Record last update hone ka timestamp
}
