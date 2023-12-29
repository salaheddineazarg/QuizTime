package com.spring.quiztime.dto.Subject;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Positive(message = "Parent ID should be a positive number")
    private Long parent_id;


}