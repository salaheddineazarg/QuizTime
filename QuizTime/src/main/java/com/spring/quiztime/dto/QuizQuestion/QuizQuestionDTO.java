package com.spring.quiztime.dto.QuizQuestion;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionDTO {


    private Long id;

    @Positive(message = "Temporization should be a positive number")
    private int temporization;

    @NotNull(message = "Quiz ID cannot be null")
    @Positive(message = "Quiz ID should be a positive number")
    private Long quiz_id;

    @NotNull(message = "Question ID cannot be null")
    @Positive(message = "Question ID should be a positive number")
    private Long question_id;
}
