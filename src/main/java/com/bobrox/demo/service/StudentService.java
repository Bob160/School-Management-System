package com.bobrox.demo.service;

import com.bobrox.demo.model.Student;
import com.bobrox.demo.request.AddStudentRequest;

import java.util.List;


public interface StudentService {
    Student addStudent(AddStudentRequest student);
    List<Student> getAllStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}


