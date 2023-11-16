package com.spring.quiztime.dto;


import com.spring.quiztime.dto.Question.QuestionDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private Long id;

    @NotNull(message = "Question can't be null")
    private QuestionDTO question;

    @NotNull(message = "Quiz ID can't be null")
    private Long quiz_id;

    @NotNull(message = "Student ID can't be null")
    private Long student_id;

    @NotNull(message = "Total Score can't be  null")
    private double totalScore;

    @NotNull(message = "Validation ID can't be null")
    private Long validation_id;

    @NotNull(message = "AssignQuizStudent ID cannot be null")
    private Long assignQuizStudent_id;
}
