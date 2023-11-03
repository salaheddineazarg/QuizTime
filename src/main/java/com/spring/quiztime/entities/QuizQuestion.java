package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {



    @Column(nullable = false)
    private int temporization;

    @Id
    @ManyToOne
    private Quiz quiz;

    @Id
    @ManyToOne
    private Question question;
}
