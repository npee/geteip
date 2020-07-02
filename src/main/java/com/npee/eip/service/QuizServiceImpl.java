package com.npee.eip.service;

import com.npee.eip.advice.exception.CustomQuizNotExistsException;
import com.npee.eip.advice.exception.CustomQuizTableEmptyException;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;
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
    public Quiz insertQuiz(RequestQuizDto quizDto) {
        return save(quizDto);
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
        return quizJpaRepository.findById(quizId).orElseThrow(CustomQuizNotExistsException::new);
    }

    @Override
    public Quiz updateQuiz(Long quizId, RequestQuizDto quizDto) {
        return null;
    }

    @Override
    public void deleteQuiz(Long quizId) {
    }

    public Quiz save(RequestQuizDto quizDto) {
        Quiz quiz = update(null, quizDto);
        return quizJpaRepository.save(quiz);
    }

    public Quiz update(Long quizId, RequestQuizDto quizDto) {
        return quizJpaRepository.save(Quiz.builder()
                .quizId(quizId)
                .year(quizDto.getYear())
                .nth(quizDto.getNth())
                .question(quizDto.getQuestion())
                .image(quizDto.getImage())
                .isCorrect(quizDto.getIsCorrect())
                .build());
    }
}
