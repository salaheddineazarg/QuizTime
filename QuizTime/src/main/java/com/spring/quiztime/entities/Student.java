package com.spring.quiztime.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.DATE)
    @NotNull(message = "Registration date cannot be null")
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<AssignQuizStudent> assignQuizStudents;

}
