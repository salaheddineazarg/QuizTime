package com.spring.quiztime.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class TeacherDTO extends UserDTO {


    private Long id;


    private String speciality;
}
