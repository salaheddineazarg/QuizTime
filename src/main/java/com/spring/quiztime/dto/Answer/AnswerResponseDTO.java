package com.spring.quiztime.dto.Answer;

import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentDTO;
import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Validation.ValidationDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponseDTO {

    private Long id;

    private double totalScore;

    private ValidationDTO validation;

    private AssignQuizStudentDTO assignQuizStudent;
}
