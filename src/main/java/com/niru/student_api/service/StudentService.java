package com.niru.student_api.service;

import com.niru.student_api.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student with id " + id + " not found"
                        ));
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        students.remove(student);
    }
}