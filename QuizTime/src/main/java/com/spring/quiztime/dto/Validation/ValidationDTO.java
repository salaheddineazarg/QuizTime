package com.spring.quiztime.dto.Validation;


import com.spring.quiztime.dto.Question.QuestionDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ValidationDTO {

    private Long id;

    @NotNull(message = "Response ID cannot be null")
    @Positive(message = "Response ID should be a positive number or zero")
    private Long response_id;

    @NotNull(message = "Question ID cannot be null")
    @Positive(message = "Question ID should be a positive number or zero")
    private Long question_id;

    @PositiveOrZero(message = "Points should be a positive number or zero")
    private double points;

}
