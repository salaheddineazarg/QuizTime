package com.spring.quiztime.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends UserDTO {

    private Long id;

    @NotBlank(message = "Speciality can't be blank")
    private String speciality;
}
