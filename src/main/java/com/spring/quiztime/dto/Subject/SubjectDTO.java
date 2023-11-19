package com.spring.quiztime.dto.Subject;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private Long id;
    @NotBlank(message = "title can't be blank")
    private String title;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long parent_id;


}