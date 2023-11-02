package com.spring.quiztime.repository;

import com.spring.quiztime.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level,Long> {

    List<Level> findAll();
}
