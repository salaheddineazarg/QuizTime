package com.spring.quiztime.dto;

import com.spring.quiztime.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private QuestionType questionType;
    private int  numberAnswers;
    private int numberCorrectAnswers;
    private int numberFalseAnswers;
    private LevelDTO level;
    private SubjectDTO Subject;


}
