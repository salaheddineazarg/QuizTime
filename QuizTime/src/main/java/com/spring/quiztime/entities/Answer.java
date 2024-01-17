package com.spring.quiztime.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Total score cannot be null")
    @DecimalMin(value = "0.0", message = "Total score must be a positive number")
    private Double totalScore;

    @ManyToOne(cascade = CascadeType.ALL)
    private Validation validation;

    @ManyToOne(cascade = CascadeType.ALL)
    private AssignQuizStudent assignQuizStudent;




}
