package com.spring.quiztime.dto.AssignQuizStudent;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.QuizDTO;
import com.spring.quiztime.dto.StudentDTO;
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
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime startDate;

    @NotNull(message = "End date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private LocalDateTime endDate;

    @Min(value = 0, message = "Score must be a positive number or zero")
    private double score;

    private String result;

    @NotBlank(message = "Reason can't be blank")
    private String reason;

    @NotNull(message = "Quiz ID cannot be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long quiz_id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private QuizDTO quiz;

    @NotNull(message = "Student ID cannot be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long student_id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StudentDTO student;

  //  private List<AnswerDTO> answer;
}
