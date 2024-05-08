package com.bobrox.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;
    @OneToMany(mappedBy = "schoolClass")
    private List<SubjectTaught> subjectsTaught;
    @ManyToMany
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;
}
