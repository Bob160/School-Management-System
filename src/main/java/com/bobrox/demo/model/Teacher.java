package com.bobrox.demo.model;

import com.bobrox.demo.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

//import javax.security.auth.Subject;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @NaturalId(mutable = true)
    private String email;
    private LocalDate dateOfBirth;
    private String department;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;

    @OneToMany(mappedBy = "teacher")
    private List<SubjectTaught> subjectsTaught;

    @ManyToMany(mappedBy = "teachers")
    private List<SchoolClass> classesAssigned;

}
