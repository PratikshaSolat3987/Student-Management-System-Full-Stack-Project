package com.example.StudentManagementSystem.Full.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository repository;

    // Create Student
    public Student saveStudent(Student student) {
        logger.debug("Attempting to save student with email: {}", student.getEmail());
        Student savedStudent = repository.save(student);
        logger.debug("Successfully saved student with ID: {}", savedStudent.getStudentId());
        return savedStudent;
    }

    // Get All Students
    public List<Student> getAllStudents() {
        logger.debug("Retrieving all students");
        List<Student> students = repository.findAll();
        logger.debug("Found {} students", students.size());
        return students;
    }

    // Get Student by ID
    public Optional<Student> getStudentById(Integer id) {
        logger.debug("Retrieving student with ID: {}", id);
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            logger.debug("Found student with ID: {}", id);
        } else {
            logger.debug("No student found with ID: {}", id);
        }
        return student;
    }

    // Get Student by Email
    public Optional<Student> getStudentByEmail(String email) {
        logger.debug("Retrieving student with email: {}", email);
        Optional<Student> student = repository.findByEmail(email);
        if (student.isPresent()) {
            logger.debug("Found student with email: {}", email);
        } else {
            logger.debug("No student found with email: {}", email);
        }
        return student;
    }

    // Update Student
    public Student updateStudent(Integer id, Student updatedStudent) {
        logger.debug("Attempting to update student with ID: {}", id);
        return repository.findById(id)
                .map(student -> {
                    logger.debug("Found student with ID: {}, updating details", id);
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhoneNumber(updatedStudent.getPhoneNumber());
                    student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
                    Student savedStudent = repository.save(student);
                    logger.debug("Successfully updated student with ID: {}", id);
                    return savedStudent;
                })
                .orElseThrow(() -> {
                    logger.debug("Failed to update - student not found with ID: {}", id);
                    return new RuntimeException("Student not found with ID: " + id);
                });
    }

    // Delete Student
    public void deleteStudent(Integer id) {
        logger.debug("Attempting to delete student with ID: {}", id);
        repository.deleteById(id);
        logger.debug("Successfully deleted student with ID: {}", id);
    }
}

