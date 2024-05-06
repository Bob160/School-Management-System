package com.bobrox.demo.request;

import com.bobrox.demo.Gender;
import com.bobrox.demo.model.Parent;
import com.bobrox.demo.model.SchoolClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AddStudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Parent parent;
    private SchoolClass schoolClass;

}