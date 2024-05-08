package com.bobrox.demo.model;


import com.bobrox.demo.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @NaturalId(mutable = true)
    private String email;
    private String address;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "student")
    private List<SubjectTaught> subjectsOffered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}
