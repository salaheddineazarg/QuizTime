package com.spring.quiztime.dto;


import com.spring.quiztime.dto.Question.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ValidationDTO {

    private Long id;

    private Long response_id;

    private Long question_id;

    private double points;


}
