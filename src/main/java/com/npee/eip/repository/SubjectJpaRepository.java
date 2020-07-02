package com.npee.eip.repository;

import com.npee.eip.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectJpaRepository extends JpaRepository<Subject, Long> {
}
