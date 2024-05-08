package com.bobrox.demo.request;

import com.bobrox.demo.Enum.Gender;
import com.bobrox.demo.model.Parent;
import com.bobrox.demo.model.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class AddStudentRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Parent parent;
    private SchoolClass schoolClass;
//    private String parentName;
//    private String parentAddress;
//    private String currentClass;
    //private String class;
    //private SchoolClass schoolClass;

}