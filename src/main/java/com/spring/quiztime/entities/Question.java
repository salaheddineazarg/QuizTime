package com.spring.quiztime.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
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

        @ManyToOne
        private Level level;

        @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
        private List<Media> medias;

        @ManyToOne
        private Subject subject;

        @OneToMany(mappedBy = "question")
        private List<Validation> validations;

}
