package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class StudentController {

    final public Map<String, Student> mapIdToStudent = new HashMap<>();
    final public Map<String, List<Student>> mapUniversityToStudent = new HashMap<>();

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        String id = UUID.randomUUID().toString();
        student.setId(id);

        mapIdToStudent.put(id, student);

        List<Student> students = mapUniversityToStudent.getOrDefault(student.getUni(), new ArrayList<>());
        students.add(student);
        mapUniversityToStudent.put(student.getUni(), students);

        return id;
    }

    @GetMapping("/getStudents/{university}")
    public List<Student> getStudentByUniversity(@PathVariable String university) {
        return mapUniversityToStudent.getOrDefault(university, new ArrayList<>());
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return mapIdToStudent.get(id);
    }
}
