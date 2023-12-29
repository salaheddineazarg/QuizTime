package com.spring.quiztime.dto.Quiz;



import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {


    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Min(value = 0, message = "Passing score should not be negative")
    private Double passingScore;

    @Positive(message = "Chances should be a positive number")
    private Integer chances;

    @Positive(message = "During should be a positive number")
    private Integer during;

    @NotBlank(message = "More Informations cannot be blank")
    private String moreInformations;

    private boolean displayResult;

    @NotNull(message = "Teacher ID cannot be null")
    private Long teacher_id;



}
