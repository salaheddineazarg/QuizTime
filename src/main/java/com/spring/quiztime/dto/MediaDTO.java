package com.spring.quiztime.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTO {

    private Long id;
    private MediaType mediaType;
    private String link;
    private String description;
    private QuestionDTO question;

}
