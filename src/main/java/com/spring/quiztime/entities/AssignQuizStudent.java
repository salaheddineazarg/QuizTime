package com.spring.quiztime.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class AssignQuizStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int chance;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @Column(nullable = true)
    private double score;

    @Column(nullable = true)
    private String result;

    @Column(length = 255)
    private String reason;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Student student;




}
