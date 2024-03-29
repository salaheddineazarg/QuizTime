package com.spring.quiztime.dto.Media;


import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.enumuration.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaResponseDTO {

    private Long id;
    private MediaType mediaType;
    private String link;
    private String description;
    private QuestionDTO question;


}
