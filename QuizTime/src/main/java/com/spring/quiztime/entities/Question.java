package com.spring.quiztime.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
    public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Text cannot be blank")
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(nullable = false)
    @Min(value = 0, message = "Number of answers should be a non-negative number")
    private int numberAnswers;

    @Column(nullable = false)
    @Min(value = 0, message = "Number of correct answers should be a non-negative number")
    private int numberCorrectAnswers;

    @Column(nullable = false)
    @Min(value = 0, message = "Number of false answers should be a non-negative number")
    private int numberFalseAnswers;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", message = "Points must be a positive number")
    private double points;

    @ManyToOne
    private Level level;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Media> medias;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question")
    private List<Validation> validations;

}
