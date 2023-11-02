package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Column(nullable = false,length = 255)
    private String link;

    @Column(nullable = false,length = 255)
    private String description;

    @ManyToOne
    private Question question;

}
