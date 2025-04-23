package com.example.StudentManagementSystem.Full.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    // Register Student
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        logger.debug("Received request to register student with email: {}", student.getEmail());
        Student savedStudent = service.saveStudent(student);
        logger.debug("Successfully registered student with ID: {}", savedStudent.getStudentId());
        return ResponseEntity.ok(savedStudent);
    }

    // Get All Students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        logger.debug("Received request to get all students");
        List<Student> students = service.getAllStudents();
        logger.debug("Returning {} students", students.size());
        return ResponseEntity.ok(students);
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        logger.debug("Received request to get student with ID: {}", id);
        Optional<Student> student = service.getStudentById(id);
        if (student.isPresent()) {
            logger.debug("Returning student with ID: {}", id);
            return ResponseEntity.ok(student.get());
        } else {
            logger.debug("Student with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Get Student by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        logger.debug("Received request to get student with email: {}", email);
        Optional<Student> student = service.getStudentByEmail(email);
        if (student.isPresent()) {
            logger.debug("Returning student with email: {}", email);
            return ResponseEntity.ok(student.get());
        } else {
            logger.debug("Student with email: {} not found", email);
            return ResponseEntity.notFound().build();
        }
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        logger.debug("Received request to update student with ID: {}", id);
        Student updatedStudent = service.updateStudent(id, student);
        logger.debug("Successfully updated student with ID: {}", id);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        logger.debug("Received request to delete student with ID: {}", id);
        service.deleteStudent(id);
        logger.debug("Successfully deleted student with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
