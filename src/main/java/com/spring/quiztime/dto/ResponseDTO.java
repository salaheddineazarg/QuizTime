package com.spring.quiztime.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Long id;
    private String text;

}
