package com.spring.quiztime.dto;


import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Quiz.QuizDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionDTO {
    private Long id;
    private int temporization;
    private QuizDTO quiz;
    private QuestionDTO question;
}
