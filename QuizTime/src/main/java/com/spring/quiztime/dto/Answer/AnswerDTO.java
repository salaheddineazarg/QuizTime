package com.spring.quiztime.dto.Answer;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private Long id;

    @NotNull(message = "Total Score can't be  null")
    private double totalScore;

    @NotNull(message = "Validation ID can't be null")
    private Long validation_id;

    @NotNull(message = "AssignQuizStudent ID cannot be null")
    private Long assignQuizStudent_id;
}
