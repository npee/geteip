package com.npee.eip.service;

import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;

import java.util.List;

public interface QuizService {
    Quiz insertQuiz(RequestQuizDto quizDto);
    List<Quiz> selectQuizzes();
    Quiz selectAQuiz(Long quizId);
    Quiz updateQuiz(Long quizId, RequestQuizDto quizDto);
    void deleteQuiz(Long quizId);
}
