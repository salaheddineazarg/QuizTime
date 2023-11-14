package com.spring.quiztime.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {

    private Long id;
    private double passingScore;
    private int chances;
    private LocalTime during;
    private boolean displayResult;
    private String moreInformations;


}
