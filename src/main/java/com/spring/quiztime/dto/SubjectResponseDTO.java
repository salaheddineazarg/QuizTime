package com.spring.quiztime.dto;




import lombok.*;

import java.util.List;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String title;
    private SubjectResponseDTO parent;
    private List<SubjectDTO> childs;
    private List<QuestionDTO> questions ;
}
