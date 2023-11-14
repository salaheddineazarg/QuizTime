package com.spring.quiztime.dto;
import com.spring.quiztime.entities.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class QuestionDTO {
        private Long id;
        private String text;
        private QuestionType questionType;
        private int  numberAnswers;
        private int numberCorrectAnswers;
        private int numberFalseAnswers;
        private Long level_id;
        private Long subject_id;


}
