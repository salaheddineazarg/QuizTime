package com.spring.quiztime.entities;

import jakarta.persistence.*;
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
    private String title;

    @Column(nullable = false)
    private double passingScore;

    @Column(nullable = false)
    private int chances;

    @Column(nullable = false)
    private int during;


    @Column(nullable = false)
    private boolean displayResult;


    private String moreInformations;


    @OneToMany(mappedBy = "quiz")
    private List<QuizQuestion> quizQuestions;

    @OneToMany(mappedBy = "quiz")
    private List<AssignQuizStudent> assignQuizStudents;

    @ManyToOne
    private Teacher teacher;
}
