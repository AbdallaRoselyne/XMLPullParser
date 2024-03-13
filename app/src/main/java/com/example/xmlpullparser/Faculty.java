package com.example.xmlpullparser;

public class Faculty {
    private int id;
    private String name;
    private String module;

    // Constructor
    public Faculty() {
        // Default constructor
    }

    // Getters and setters for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for module
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    // Override toString() method to provide custom string representation
    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", module='" + module + '\'' +
                '}';
    }
}
