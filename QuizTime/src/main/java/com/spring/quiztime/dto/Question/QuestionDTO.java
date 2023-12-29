package com.spring.quiztime.dto.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.Media.MediaDTO;
import com.spring.quiztime.entities.QuestionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {



        private Long id;

        @NotBlank(message = "Text cannot be blank")
        private String text;

        @NotNull(message = "Question type cannot be null")
        private QuestionType questionType;

        @PositiveOrZero(message = "Number of answers should be positive or zero")
        private int numberAnswers;

        @Min(value = 0, message = "Number of correct answers should be a non-negative number")
        private int numberCorrectAnswers;

        @Min(value = 0, message = "Number of false answers should be a non-negative number")
        private int numberFalseAnswers;

        @PositiveOrZero(message = "Points should be positive or zero")
        private double points;

        private Long level_id;

        private Long subject_id;

        private List<MediaDTO> medias;


}
