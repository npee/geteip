package com.npee.eip.service;

import com.npee.eip.advice.exception.CustomQuizTableEmptyException;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.repository.QuizJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {

    private final QuizJpaRepository quizJpaRepository;

    @Override
    public Quiz insertQuiz(Long year, String nth, String question, String image, String isCorrect) {

        return null;
    }

    @Override
    public List<Quiz> selectQuizzes()  {
        List<Quiz> quizList = quizJpaRepository.findAll();
        if (quizList.isEmpty()) {
            throw new CustomQuizTableEmptyException();
        } else {
            return quizList;
        }
    }

    @Override
    public Quiz selectAQuiz(Long quizId) {
        return null;
    }

    @Override
    public Quiz updateQuiz(Long quizId, Long year, String nth, String question, String image, String isCorrect) {
        return null;
    }

    @Override
    public void deleteQuiz(Long quizId) {
    }

}
