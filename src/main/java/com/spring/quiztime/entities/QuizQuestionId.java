package com.spring.quiztime.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;


@Embeddable
public class QuizQuestionId implements Serializable {



    private Quiz quiz;


    private Question question;
}
