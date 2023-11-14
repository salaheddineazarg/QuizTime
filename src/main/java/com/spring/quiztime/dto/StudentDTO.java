package com.spring.quiztime.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends UserDTO {


    private Long id;
    private LocalDate registrationDate;



}
