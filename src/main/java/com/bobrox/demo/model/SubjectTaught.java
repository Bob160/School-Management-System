package com.bobrox.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectTaught {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@OneToMany(mappedBy = "subjectTaught")
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
