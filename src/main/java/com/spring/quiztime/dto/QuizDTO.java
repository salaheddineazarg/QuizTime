package com.spring.quiztime.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.quiztime.dto.TeacherDTO;
import com.spring.quiztime.entities.Teacher;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {

    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Passing score cannot be null")
    @Min(value = 0, message = "Passing score must be a positive number")
    private Double passingScore;

    @Min(value = 1, message = "Chances must be at least 1")
    private Integer chances;

    @Min(value = 1, message = "Duration must be at least 1")
    private Integer during;

    @NotBlank(message = "More informations can't be blanck")
    private String moreInformations;

    private boolean displayResult;

    @NotNull(message = "Teacher ID can't be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long teacher_id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TeacherDTO teacher;

}
