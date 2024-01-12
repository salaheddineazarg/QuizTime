package com.spring.quiztime.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Response cannot be null")
    private Response response;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Question cannot be null")
    private Question question;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", message = "Points must be a positive number")
    private double points;

    @OneToMany(mappedBy = "validation",orphanRemoval = true)
    private List<Answer> answers;

}
