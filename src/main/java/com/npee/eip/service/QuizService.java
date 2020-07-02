package com.npee.eip.service;

import com.npee.eip.model.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz insertQuiz(Long year, String nth, String question, String image, String isCorrect);
    List<Quiz> selectQuizzes();
    Quiz selectAQuiz(Long quizId);
    Quiz updateQuiz(Long quizId, Long year, String nth, String question, String image, String isCorrect);
    void deleteQuiz(Long quizId);
}
