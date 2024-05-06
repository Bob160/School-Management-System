package com.bobrox.demo.controller;

import com.bobrox.demo.model.Student;
import com.bobrox.demo.request.AddStudentRequest;
import com.bobrox.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>>  getStudents() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody AddStudentRequest student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

}
