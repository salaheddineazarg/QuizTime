
package com.spring.quiztime.repository;

import com.spring.quiztime.entities.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {


     List<QuizQuestion> findByQuizId(Long id);



}

