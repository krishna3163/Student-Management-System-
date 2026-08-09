# 🎓 Student Management System - Spring Boot & MongoDB REST API

A clean, production-ready **Spring Boot REST API** built with **Java**, **Spring Data MongoDB**, and **MongoDB**. Specially designed for Indian students creating their first project in Spring Boot. All code comments are in easy-to-understand **Hinglish**!

---

## 🛠️ Technology Stack

- **Language**: Java 17+
- **Framework**: Spring Boot 3.2.3
- **Database**: MongoDB (Local or MongoDB Atlas)
- **Data Access**: Spring Data MongoDB (`MongoRepository`)
- **Validation**: Jakarta Bean Validation (`@Valid`, `@Email`, `@NotBlank`)
- **Utilities**: Project Lombok (code boilerplate kam karne ke liye)
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

## 🚀 Step 1: Database Setup (MongoDB Setup)

### Option A: Local MongoDB
1. Ensure karein ki local MongoDB Community Server aapke PC par install hai aur port `27017` par run ho raha hai.
2. Spring Boot application first record insert karte hi `student_db` database aur `students` collection automatic create kar dega.

### Option B: MongoDB Atlas (Cloud Database)
1. Free account banayein [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) par.
2. `src/main/resources/application.properties` file open karein aur URI replace karein:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/student_db?retryWrites=true&w=majority
   ```

---

## 🏃 Step 2: Spring Boot Application Run Karein

### Command Line se Run karne ke liye:
```bash
# Terminal / PowerShell me command chalayein:
mvn spring-boot:run
```

### IDE (IntelliJ / Eclipse / VS Code) se Run karne ke liye:
1. `Student-Management-System` folder open karein.
2. `src/main/java/com/example/studentmanagement/StudentManagementApplication.java` par right-click karke **Run** press karein.

Application URL: `http://localhost:8080/api/v1/students`

---

## 📬 Step 3: Postman se API Test Karein

Postman Collection JSON file yahan milti hai:
📄 [postman/Student_Management_System.postman_collection.json](file:///f:/Student-Management-System/postman/Student_Management_System.postman_collection.json)

### Import Kaise Karein:
1. Postman app open karein.
2. Top-left corner me **Import** button par click karein.
3. `postman/Student_Management_System.postman_collection.json` file select karke import karein.

---

## 📋 REST API Endpoints Table

| Method | Endpoint | Description | Status Code |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/students` | Naya student add karein | `201 Created` |
| `GET` | `/api/v1/students` | Saare students fetch karein | `200 OK` |
| `GET` | `/api/v1/students/{id}` | MongoDB ID se student search karein | `200 OK` / `404 Not Found` |
| `GET` | `/api/v1/students/department/{dept}` | Department se filter karein | `200 OK` |
| `GET` | `/api/v1/students/gpa?minGpa=3.5` | Minimum GPA se filter karein | `200 OK` |
| `PUT` | `/api/v1/students/{id}` | Student update karein | `200 OK` / `404 Not Found` |
| `DELETE` | `/api/v1/students/{id}` | Student delete karein | `200 OK` / `404 Not Found` |

---

## 💡 Sample JSON Payload (Indian Student Example)

### Create Student Request (`POST /api/v1/students`)
```json
{
    "firstName": "Aarav",
    "lastName": "Sharma",
    "email": "aarav.sharma@university.ac.in",
    "department": "Computer Science",
    "gpa": 3.85,
    "enrolledCourses": [
        "Data Structures & Algorithms",
        "Database Management Systems",
        "Web Development with React"
    ]
}
```

### Response (`201 Created`)
```json
{
    "id": "65c3f1a2b938914d328419ef",
    "firstName": "Aarav",
    "lastName": "Sharma",
    "email": "aarav.sharma@university.ac.in",
    "department": "Computer Science",
    "gpa": 3.85,
    "enrolledCourses": [
        "Data Structures & Algorithms",
        "Database Management Systems",
        "Web Development with React"
    ],
    "createdAt": "2026-08-09T10:30:00",
    "updatedAt": "2026-08-09T10:30:00"
}
```
