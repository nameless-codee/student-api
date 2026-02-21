package com.niru.student_api.controller;

import com.niru.student_api.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

// REST API class
@RestController
// Base URL for all student-related endpoints
@RequestMapping("/api/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    // @RequestBody converts JSON → Java object
    public Student addStudent(@RequestBody Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    @GetMapping("/{id}")
    // @PathVariable grabs the {id} from the URL
    public Student getStudentById(@PathVariable Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Student with id " + id + " not found"
                )); // `ResponseStatusException` gives a clean 404 Not Found instead of confusing errors
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        Student existing = getStudentById(id); // reuse logic + 404 behavior
        students.remove(existing);
    }
}