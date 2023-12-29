package com.spring.quiztime.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Column(nullable = false)
    @NotBlank(message = "Link cannot be blank")
    private String link;

    @Column(nullable = false)
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @ManyToOne
    private Question question;


}
