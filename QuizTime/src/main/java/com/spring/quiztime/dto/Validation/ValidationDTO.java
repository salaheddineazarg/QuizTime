package com.spring.quiztime.dto.Validation;


import com.spring.quiztime.dto.Question.QuestionDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ValidationDTO {

    private Long id;

    @NotNull(message = "Response ID can't be null")
    private Long response_id;

    @NotNull(message = "Question ID can't be null")
    private Long question_id;

    @Min(value =0, message = "Points must be a positive number or zero")
    private double points;


}
