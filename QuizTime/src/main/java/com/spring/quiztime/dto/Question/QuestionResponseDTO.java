package com.spring.quiztime.dto.Question;

import com.spring.quiztime.dto.LevelDTO;
import com.spring.quiztime.dto.Media.MediaDTO;
import com.spring.quiztime.dto.Subject.SubjectDTO;
import com.spring.quiztime.enumuration.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
    private double points;
    private LevelDTO level;
    private SubjectDTO Subject;
    private List<MediaDTO> medias;


}
