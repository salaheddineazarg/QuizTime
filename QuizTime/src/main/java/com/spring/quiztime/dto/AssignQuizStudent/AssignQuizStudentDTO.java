package com.spring.quiztime.dto.AssignQuizStudent;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.Quiz.QuizDTO;
import com.spring.quiztime.dto.StudentDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class AssignQuizStudentDTO {


    private Long id;

    @PositiveOrZero(message = "Chance should be a positive number or zero")
    private int chance;

    @NotNull(message = "Start date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime startDate;

    @NotNull(message = "End date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime endDate;

    @DecimalMin(value = "0", message = "Score must be greater than or equal to zero")
    private double score;

    @NotBlank(message = "Result cannot be blank")
    private String result;

    @NotBlank(message = "Reason cannot be blank")
    private String reason;

    @NotNull(message = "Quiz ID cannot be null")
    @Positive(message = "Quiz ID should be a positive number")
    private Long quiz_id;

    @NotNull(message = "Student ID cannot be null")
    @Positive(message = "Student ID should be a positive number")
    private Long student_id;




}
