package com.spring.quiztime.dto.AssignQuizStudent;


import com.spring.quiztime.dto.Quiz.QuizDTO;
import com.spring.quiztime.dto.StudentDTO;

import lombok.Data;

import java.time.LocalDateTime;

 @Data
public class AssignQuizStudentResponseDTO {


    private Long id;
    private int chance;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double score;
    private String result;
    private String reason;
    private QuizDTO quiz;
    private StudentDTO student;
}
