package com.spring.quiztime.repository;

import com.spring.quiztime.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz,Long> {



  }
