package com.spring.quiztime.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends UserDTO {


    private Long id;

    @NotNull(message = "Registration date can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;



}
