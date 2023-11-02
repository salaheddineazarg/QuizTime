package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class QuizQuestion {


    @Column(nullable = false)
    private int temporization;


    @Id
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
