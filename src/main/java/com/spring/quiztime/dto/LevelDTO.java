package com.spring.quiztime.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDTO {

    private Long id;

    private String name;

    private int maxPoints;

    private int minPoints;

}