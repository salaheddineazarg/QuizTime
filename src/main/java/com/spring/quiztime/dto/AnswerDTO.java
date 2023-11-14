package com.spring.quiztime.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private QuestionDTO question;

    @ManyToOne
    private QuizDTO quiz;

    @ManyToOne
    private StudentDTO student;

    @Column(nullable = false)
    private double totalScore;

    @ManyToOne
    private ValidationDTO validation;

    @ManyToOne
    private AssignQuizStudentDTO assignQuizStudent;
}
