package com.npee.eip.repository;

import com.npee.eip.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizJpaRepository extends JpaRepository<Quiz, Long> {
}
