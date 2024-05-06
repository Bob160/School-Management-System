package com.bobrox.demo.service;

import com.bobrox.demo.model.Student;
import com.bobrox.demo.model.Teacher;
import com.bobrox.demo.request.AddTeacherRequest;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(AddTeacherRequest teacher);
    List<Teacher> getAllTeachers();
    Teacher updateTeacher(Teacher teacher, Long id);
    Teacher getTeacherById(Long id);
    void deleteTeacher(Long id);
}
