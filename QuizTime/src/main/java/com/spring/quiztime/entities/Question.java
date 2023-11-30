package com.spring.quiztime.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
    public class Question {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String text;

        @Enumerated(EnumType.STRING)
        private QuestionType questionType;

        @Column(nullable = false)
        private int  numberAnswers;

        @Column(nullable = false )
        private int numberCorrectAnswers;

        @Column(nullable = false)
        private int numberFalseAnswers;

        @Column(nullable = false)
        private double points;

        @ManyToOne
        private Level level;

        @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
        private List<Media> medias;

        @ManyToOne
        private Subject subject;

        @OneToMany(mappedBy = "question")
        private List<Validation> validations;

}
