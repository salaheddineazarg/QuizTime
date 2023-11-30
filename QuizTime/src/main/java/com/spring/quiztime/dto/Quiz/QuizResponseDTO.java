package com.spring.quiztime.dto.Quiz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.TeacherDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuizResponseDTO {

    private Long id;

    private String title;

    private Double passingScore;

    private Integer chances;

    private Integer during;

    private String moreInformations;

    private boolean displayResult;

    private TeacherDTO teacher;
}
