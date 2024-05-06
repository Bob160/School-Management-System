package com.bobrox.demo.controller;

import com.bobrox.demo.model.Teacher;
import com.bobrox.demo.request.AddTeacherRequest;
import com.bobrox.demo.serviceImpl.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teachers")
public class TeacherController {

    public final TeacherServiceImpl teacherService;

    @GetMapping("/get-all-teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(), HttpStatus.OK);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody AddTeacherRequest teacherRequest) {
        return new ResponseEntity<Teacher>(teacherService.addTeacher(teacherRequest), HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
//        return studentService.updateStudent(student, id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteStudent(@PathVariable("id") Long id){
//        studentService.deleteStudent(id);
//    }
//
//    @GetMapping("/getStudent/{id}")
//    public Student getStudentById(@PathVariable("id") Long id) {
//        return studentService.getStudentById(id);
//    }
}
