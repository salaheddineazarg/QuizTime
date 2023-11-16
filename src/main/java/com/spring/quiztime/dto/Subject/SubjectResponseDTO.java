package com.spring.quiztime.dto.Subject;




import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Question.QuestionResponseDTO;
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
