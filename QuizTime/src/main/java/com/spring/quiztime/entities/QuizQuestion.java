package com.spring.quiztime.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 0, message = "Temporization should be a non-negative number")
    private int temporization;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Quiz cannot be null")
    private Quiz quiz;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Question cannot be null")
    private Question question;
}
