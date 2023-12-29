package com.spring.quiztime.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends UserDTO {


    private Long id;

    @NotNull(message = "Registration date cannot be null")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Registration date should be in yyyy-MM-dd format")
    private LocalDate registrationDate;




}
