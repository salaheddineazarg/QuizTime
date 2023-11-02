package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class QuizQuestion {

   @EmbeddedId
    private QuizQuestionId quizQuestionId;

    @Column(nullable = false)
    private int temporization;



    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
