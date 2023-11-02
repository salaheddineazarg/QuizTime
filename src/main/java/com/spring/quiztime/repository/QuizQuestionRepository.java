package com.spring.quiztime.repository;

import com.spring.quiztime.entities.QuizQuestion;
import com.spring.quiztime.entities.QuizQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, QuizQuestionId> {


}
