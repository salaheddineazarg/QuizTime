package com.spring.quiztime.dto;



import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class AssignQuizStudentDTO {

    private Long id;
    private int chance;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double score;
    private String result;
    private String reason;
    private QuizDTO quiz;
    private StudentDTO student;
    private List<AnswerDTO> answer;
}
