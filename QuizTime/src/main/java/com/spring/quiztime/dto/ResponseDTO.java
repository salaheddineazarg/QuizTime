package com.spring.quiztime.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDTO {


    private Long id;

    @NotBlank(message = "Text cannot be blank")
    private String text;

}
