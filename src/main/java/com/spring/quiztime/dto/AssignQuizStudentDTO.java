package com.spring.quiztime.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class AssignQuizStudentDTO {

    private Long id;

    @Min(value = 1, message = "Chance must be at least 1")
    private int chance;

    @NotNull(message = "Start date cannot be null")
    private LocalDateTime startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDateTime endDate;

    @Min(value = 0, message = "Score must be a positive number or zero")
    private double score;

    // Assuming result and reason can't be blank, though it depends on your use case
    @NotBlank(message = "Result cannot be blank")
    private String result;

    @NotBlank(message = "Reason cannot be blank")
    private String reason;

    @NotNull(message = "Quiz ID cannot be null")
    private Long quiz_id;

    @NotNull(message = "Student ID cannot be null")
    private Long student_id;

    private List<AnswerDTO> answer;
}
