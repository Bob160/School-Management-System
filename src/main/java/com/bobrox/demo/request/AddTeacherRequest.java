package com.bobrox.demo.request;


import com.bobrox.demo.Enum.Gender;
import com.bobrox.demo.model.SchoolClass;
import com.bobrox.demo.model.SubjectTaught;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class AddTeacherRequest {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String department;
    private Gender gender;
    private String address;
    private List<SubjectTaught> subjectsTaught;
    private List<SchoolClass> classesAssigned;
}
