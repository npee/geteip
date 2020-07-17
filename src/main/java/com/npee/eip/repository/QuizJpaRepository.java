package com.npee.eip.repository;

import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.response.ResponseQuizCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizJpaRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT new com.npee.eip.model.response.ResponseQuizCountDto(q1.year, q1.nth, q1.subjectId, COUNT(DISTINCT q2.quizId))" +
            "FROM Quiz q1 LEFT JOIN Quiz q2 ON q1.year = q2.year AND q1.nth = q2.nth AND q1.subjectId = q2.subjectId GROUP BY " +
            "q1.year, q1.nth, q1.subjectId")
    List<ResponseQuizCountDto> selectQuizCountByYearAndNthAndSubjectId();
}
