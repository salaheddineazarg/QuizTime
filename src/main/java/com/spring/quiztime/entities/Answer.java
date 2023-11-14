package com.spring.quiztime.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Student student;

    @Column(nullable = false)
    private double totalScore;

    @ManyToOne
    private Validation validation;

    @ManyToOne
    private AssignQuizStudent assignQuizStudent;
}
