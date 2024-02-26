package com.example.demo.model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String adhar;
    private String uni;

    public Student(String id, String name, int age, String adhar, String uni) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adhar = adhar;
        this.uni = uni;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdhar() {
        return adhar;
    }

    public String getUni() {
        return uni;
    }
}
