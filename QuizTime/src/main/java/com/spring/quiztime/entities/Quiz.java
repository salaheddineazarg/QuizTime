package com.spring.quiztime.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", message = "Passing score must be a positive number")
    private double passingScore;

    @Column(nullable = false)
    @Min(value = 1, message = "Chances should be a positive number")
    private int chances;

    @Column(nullable = false)
    @Min(value = 1, message = "Duration should be a positive number")
    private int during;

    @Column(nullable = false)
    private boolean displayResult;

    @NotBlank(message = "More Informations cannot be blank")
    private String moreInformations;

    @OneToMany(mappedBy = "quiz",orphanRemoval = true)
    private List<QuizQuestion> quizQuestions;

    @OneToMany(mappedBy = "quiz",orphanRemoval = true)
    private List<AssignQuizStudent> assignQuizStudents;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
