# 🎓 Student Management System - Spring Boot & MongoDB REST API

A clean, production-ready, beginner-friendly **Spring Boot REST API** built with **Java**, **Spring Data MongoDB**, and **MongoDB**. Designed for students taking their first steps into Spring Boot development and RESTful web service architecture.

---

## 🛠️ Technology Stack

- **Language**: Java 17+
- **Framework**: Spring Boot 3.2.3
- **Database**: MongoDB (Local or MongoDB Atlas)
- **Data Access**: Spring Data MongoDB (`MongoRepository`)
- **Validation**: Jakarta Bean Validation (`@Valid`, `@Email`, `@NotBlank`)
- **Utilities**: Project Lombok (reduces boilerplate code)
- **API Testing**: Postman (Pre-built Collection included)

---

## 📁 Project Structure

```
Student-Management-System/
├── pom.xml
├── postman/
│   └── Student_Management_System.postman_collection.json
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── studentmanagement/
│       │               ├── StudentManagementApplication.java
│       │               ├── controller/
│       │               │   └── StudentController.java
│       │               ├── exception/
│       │               │   ├── DuplicateResourceException.java
│       │               │   ├── GlobalExceptionHandler.java
│       │               │   └── ResourceNotFoundException.java
│       │               ├── model/
│       │               │   └── Student.java
│       │               ├── payload/
│       │               │   └── ErrorDetails.java
│       │               ├── repository/
│       │               │   └── StudentRepository.java
│       │               └── service/
│       │                   ├── StudentService.java
│       │                   └── impl/
│       │                       └── StudentServiceImpl.java
│       └── resources/
│           └── application.properties
└── README.md
```

---

## 🚀 Step 1: Database Setup (MongoDB)

### Option A: Local MongoDB
1. Ensure MongoDB Community Server is installed and running on default port `27017`.
2. The application will automatically create the database `student_db` and collection `students` on first insertion.

### Option B: MongoDB Atlas (Cloud)
1. Sign up for a free tier at [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Create a database cluster and get your connection string.
3. Open `src/main/resources/application.properties` and replace the URI:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/student_db?retryWrites=true&w=majority
   ```

---

## 🏃 Step 2: Running the Spring Boot Application

### Using Maven Command Line:
```bash
# In Windows PowerShell / CMD:
mvn spring-boot:run
```

### Using IDE (IntelliJ IDEA / Eclipse / VS Code):
1. Open `Student-Management-System` directory in your IDE.
2. Locate `src/main/java/com/example/studentmanagement/StudentManagementApplication.java`.
3. Right-click and choose **Run 'StudentManagementApplication'**.

The application will start on port `8080` at: `http://localhost:8080/api/v1/students`

---

## 📬 Step 3: API Testing with Postman

A ready-to-import Postman Collection is included in the project under the `postman/` directory:
📄 [postman/Student_Management_System.postman_collection.json](file:///f:/Student-Management-System/postman/Student_Management_System.postman_collection.json)

### How to Import into Postman:
1. Open Postman.
2. Click the **Import** button in the top-left corner.
3. Choose **File** -> Select `postman/Student_Management_System.postman_collection.json`.
4. Run requests directly!

---

## 📋 REST API Endpoints Reference

| Method | Endpoint | Description | Status Code |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/students` | Create a new student | `201 Created` |
| `GET` | `/api/v1/students` | Get all students | `200 OK` |
| `GET` | `/api/v1/students/{id}` | Get student by MongoDB ID | `200 OK` / `404 Not Found` |
| `GET` | `/api/v1/students/department/{dept}` | Filter students by department | `200 OK` |
| `GET` | `/api/v1/students/gpa?minGpa=3.5` | Filter students by minimum GPA | `200 OK` |
| `PUT` | `/api/v1/students/{id}` | Update student details | `200 OK` / `404 Not Found` |
| `DELETE` | `/api/v1/students/{id}` | Delete student by ID | `200 OK` / `404 Not Found` |

---

## 💡 Sample Requests & Responses

### 1. Create Student (`POST /api/v1/students`)
**Request Body**:
```json
{
    "firstName": "Alex",
    "lastName": "Morgan",
    "email": "alex.morgan@university.edu",
    "department": "Computer Science",
    "gpa": 3.85,
    "enrolledCourses": [
        "Data Structures",
        "Database Systems",
        "Web Development"
    ]
}
```

**Response Body (`201 Created`)**:
```json
{
    "id": "65c3f1a2b938914d328419ef",
    "firstName": "Alex",
    "lastName": "Morgan",
    "email": "alex.morgan@university.edu",
    "department": "Computer Science",
    "gpa": 3.85,
    "enrolledCourses": [
        "Data Structures",
        "Database Systems",
        "Web Development"
    ],
    "createdAt": "2026-08-09T10:30:00",
    "updatedAt": "2026-08-09T10:30:00"
}
```

---

## 📌 Features Learned in this Project

1. **Layered Architecture**: Separation of concerns (`Controller` -> `Service` -> `Repository` -> `Model`).
2. **Spring Data MongoDB**: Utilizing `MongoRepository` for automatic CRUD logic and custom query methods without writing boilerplate queries.
3. **Request Validation**: Automatic request body checks via `@Valid` annotations.
4. **Global Exception Handling**: Centralized exception handler using `@RestControllerAdvice` returning standard HTTP error payloads.
