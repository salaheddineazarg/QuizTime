package com.spring.quiztime.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends UserDTO {

    private Long id;

    @NotNull(message = "Speciality cannot be null")
    private String speciality;
}
