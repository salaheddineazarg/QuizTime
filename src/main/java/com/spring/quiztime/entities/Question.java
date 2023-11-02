package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(name = "numberAnswers")
    private int  numberAnswers;

    @Column(name = "numberCorrectAnswers" )
    private int numberCorrectAnswers;

    @Column(name ="numberFalseAnswers")
    private int numberFalseAnswers;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;


    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<Media> medias;




}
