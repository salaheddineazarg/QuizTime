package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Response response;

    @ManyToOne
    private Question question;

    @Column(nullable = false)
    private double points;

    @OneToMany(mappedBy = "validation")
     private List<Answer> answers ;

}
