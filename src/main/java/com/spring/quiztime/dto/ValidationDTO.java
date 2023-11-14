package com.spring.quiztime.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ValidationDTO {

    private Long id;

    private ResponseDTO response;

    private QuestionDTO question;

    private double points;


}
