package com.npee.eip.service;

import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.model.response.ResponseQuizCountDto;

import java.util.List;

public interface QuizService {
    Quiz insertQuiz(RequestQuizDto quizDto);
    List<Quiz> selectQuizzes();
    Quiz selectAQuiz(Long quizId);
    List<ResponseQuizCountDto> countByYearAndNthAndSubjectIdAtSelectedAllQuiz();
    Quiz updateQuiz(Long quizId, RequestQuizDto quizDto);
    void deleteQuiz(Long quizId);
}
