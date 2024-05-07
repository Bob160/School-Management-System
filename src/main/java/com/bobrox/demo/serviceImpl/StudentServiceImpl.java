package com.bobrox.demo.serviceImpl;

import com.bobrox.demo.exception.StudentAlreadyExistsException;
import com.bobrox.demo.exception.StudentNotFoundException;
import com.bobrox.demo.model.Student;
import com.bobrox.demo.repository.StudentRepository;
import com.bobrox.demo.request.AddStudentRequest;
import com.bobrox.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(AddStudentRequest studentRequest) {
        if (studentAlreadyExists(studentRequest.getEmail())) {
            throw new StudentAlreadyExistsException(studentRequest.getEmail() + " already exist!");
        }
        Student newStudent = new Student();
        newStudent.setAddress(studentRequest.getAddress());
        newStudent.setEmail(studentRequest.getEmail());
        newStudent.setLastName(studentRequest.getLastName());
        newStudent.setFirstName(studentRequest.getFirstName());
        newStudent.setGender(studentRequest.getGender());
        newStudent.setParent(studentRequest.getParent());
        newStudent.setDateOfBirth(studentRequest.getDateOfBirth());
        newStudent.setSchoolClass(studentRequest.getSchoolClass());
        return studentRepository.save(newStudent);
    }


    @Override
    public List<Student> getAllStudents() {
        //return List.of();
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        //if (studentAlreadyExists(student.getEmail()))
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setAddress(student.getAddress());
            st.setSchoolClass(student.getSchoolClass());
            st.setDateOfBirth(student.getDateOfBirth());
            st.setParent(student.getParent());
            st.setGender(student.getGender());
            return studentRepository.save(st);

        }).orElseThrow(() -> new StudentNotFoundException("sorry, student with id " + student.getId() + " could not be found!"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("sorry, student with id " + id + " could not be found!"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("sorry, student with id " + id + " could not be found!");
        } else {
            studentRepository.deleteById(id);
        }
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
