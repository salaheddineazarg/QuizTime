package com.spring.quiztime.dto.Validation;

import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.ResponseDTO;
import lombok.Data;

@Data
public class ValidationResponseDTO {
    private Long id;

    private ResponseDTO response;

    private QuestionDTO question;

    private double points;
}
