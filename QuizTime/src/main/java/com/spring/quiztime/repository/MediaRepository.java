package com.spring.quiztime.repository;

import com.spring.quiztime.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,Long> {
}
