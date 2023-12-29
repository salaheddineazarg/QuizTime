package com.spring.quiztime.dto.Media;


import com.spring.quiztime.entities.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTO {


    private Long id;

    @NotNull(message = "Media type cannot be null")
    private MediaType mediaType;

    @NotBlank(message = "Link cannot be blank")
    private String link;

    @NotBlank(message = "Description cannot be blank")
    private String description;



}
