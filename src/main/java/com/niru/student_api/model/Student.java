package com.niru.student_api.model;

public class Student {

    private Long id;
    private String name;
    private String email;

    // Jackson creates an empty constructor for JSON
    public Student() {
        // Default constructor required for JSON
    }

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // GETTERS & SETTERS
    // Jackson uses these to serialize and deserialize JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}