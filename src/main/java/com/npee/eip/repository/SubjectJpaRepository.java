package com.npee.eip.repository;

import com.npee.eip.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectJpaRepository extends JpaRepository<Subject, Long> {
}
