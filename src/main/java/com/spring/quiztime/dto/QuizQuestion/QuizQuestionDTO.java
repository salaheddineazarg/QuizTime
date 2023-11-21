package com.spring.quiztime.dto;


import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Quiz.QuizDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionDTO {

    /*private Long id;
    @Min(value = 0, message = "Temporization must be a non-negative value")
    private int temporization;

    @NotNull(message = "Quiz ID can't be null")
    private Long quiz_id;

    @NotNull(message = "Question ID can't be null")
    private Long question_id; */
}
