package com.spring.quiztime.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.Question.QuestionDTO;
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
public class LevelDTO {

    private Long id;

    @NotBlank(message = "Name can't be blank")
    private String name;

    @Min(value = 0, message = "Maximum points must be a positive number or zero")
    private int maxPoints;

    @Min(value = 0, message = "Minimum points must be a positive number or zero")
    private int minPoints;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<QuestionDTO> questions;
}
