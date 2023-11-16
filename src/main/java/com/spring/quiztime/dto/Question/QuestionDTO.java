package com.spring.quiztime.dto.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.MediaDTO;
import com.spring.quiztime.entities.Level;
import com.spring.quiztime.entities.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class QuestionDTO {
        private Long id;
        @NotBlank(message = "Text can't be blank")
        private String text;

        @NotNull(message = "Question type can't be null")
        private QuestionType questionType;

        @Min(value = 0, message = "Number of answers must be 0 or a positive number")
        private int numberAnswers;

        @Min(value = 0, message = "Number of correct answers must be 0 or a positive number")
        private int numberCorrectAnswers;

        @Min(value = 0, message = "Number of false answers must be 0 or a positive number")
        private int numberFalseAnswers;

        @Min(value = 0, message = "Points must be a positive number or zero")
        private double points;

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotNull(message = "Level ID can't be null")
        private Long level_id;

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotNull(message = "Subject ID can't be null")
        private Long subject_id;



}
