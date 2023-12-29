package com.spring.quiztime.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.Question.QuestionDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Positive(message = "Max points should be a positive number or zero")
    private int maxPoints;

    @PositiveOrZero(message = "Min points should be a positive number or zero")
    private int minPoints;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<QuestionDTO> questions;
}
