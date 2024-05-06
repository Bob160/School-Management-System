package com.bobrox.demo.serviceImpl;

import com.bobrox.demo.exception.TeacherAlreadyExistsException;
import com.bobrox.demo.exception.TeacherNotFoundException;
import com.bobrox.demo.model.Teacher;
import com.bobrox.demo.repository.TeacherRepository;
import com.bobrox.demo.request.AddTeacherRequest;
import com.bobrox.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Override
    public Teacher addTeacher(AddTeacherRequest teacher) {
        if (teacherAlreadyExists(teacher.getEmail())) {
            throw new TeacherAlreadyExistsException(teacher.getEmail() + " already exist!");
        }

        Teacher newTeacher = new Teacher();
        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getLastName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setDepartment(teacher.getDepartment());
        newTeacher.setDateOfBirth(teacher.getDateOfBirth());
        newTeacher.setClassesAssigned(teacher.getClassesAssigned());
        newTeacher.setSubjectsTaught(teacher.getSubjectsTaught());
        newTeacher.setGender(teacher.getGender());
        teacherRepository.save(newTeacher);
        return newTeacher;
    }
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Long id) {
        Teacher updatedTeacher = teacherRepository.findByEmail(teacher.getEmail()).orElseThrow(() -> new TeacherNotFoundException("Sorry, teacher with email " + teacher.getEmail() + " could not be found!"));

        if (updatedTeacher.getEmail().equals(teacher.getEmail())) {
            updatedTeacher.setFirstName(teacher.getFirstName());
            updatedTeacher.setLastName(teacher.getLastName());
            updatedTeacher.setDepartment(teacher.getDepartment());
            updatedTeacher.setEmail(teacher.getEmail());
            updatedTeacher.setDob(teacher.getDob());

        }
        return teacherRepository.save(updatedTeacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Sorry, teacher with id: " + id + " does not exist!"));
    }

    @Override
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException("sorry, teacher with id " + id + " could not be found!");
        } else {
            teacherRepository.deleteById(id);
        }

    }

    private boolean teacherAlreadyExists(String email) {
        return teacherRepository.findByEmail(email).isPresent();
    }
}
