package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long passingScore;

    @Column(nullable = false)
    private int chances;

    @Temporal(TemporalType.TIME)
    private LocalTime during;


    @Column(nullable = false)
    private boolean disabled;


    private String moreInformations;


    @OneToMany(mappedBy = "quiz")
    private List<QuizQuestion> quizQuestions;




}
