package com.spring.quiztime.repository;

import com.spring.quiztime.entities.AssignQuizStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AssignQuizStudentRepository extends JpaRepository<AssignQuizStudent,Long> {


    List<AssignQuizStudent> findByQuizId(Long id);
}
