package com.spring.quiztime.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class AssignQuizStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 0, message = "Chance should be a positive number or zero")
    private int chance;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Start date cannot be null")
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "End date cannot be null")
    private LocalDateTime endDate;

    @DecimalMin(value = "0.0", message = "Score must be a positive number")
    private Double score;

    @Size(max = 255, message = "Result length should be at most 255 characters")
    private String result;

    @Size(max = 255, message = "Reason length should be at most 255 characters")
    private String reason;

    @ManyToOne
    @NotNull(message = "Quiz cannot be null")
    private Quiz quiz;

    @ManyToOne
    @NotNull(message = "Student cannot be null")
    private Student student;

    @OneToMany(mappedBy = "assignQuizStudent")
    private List<Answer> answer;
}
