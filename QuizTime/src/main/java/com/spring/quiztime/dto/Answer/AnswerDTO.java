package com.spring.quiztime.dto.Answer;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {



    private Long id;

    @DecimalMin(value = "0.0", message = "Total score must be greater than or equal to zero")
    private double totalScore;

    @NotNull(message = "Validation ID cannot be null")
    @Positive(message = "Validation ID should be a positive  number")
    private Long validation_id;

    @NotNull(message = "Assign quiz student ID cannot be null")
    @Positive(message = "Assign quiz student ID should be a positive number")
    private Long assignQuizStudent_id;
}
