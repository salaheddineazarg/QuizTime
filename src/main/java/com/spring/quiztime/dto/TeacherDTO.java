package com.spring.quiztime.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends UserDTO {

    private Long id;

    @NotBlank(message = "Speciality can't be blank")
    private String speciality;
}
