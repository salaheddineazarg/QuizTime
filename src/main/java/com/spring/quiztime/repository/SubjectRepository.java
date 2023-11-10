package com.spring.quiztime.repository;

import com.spring.quiztime.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {


}
