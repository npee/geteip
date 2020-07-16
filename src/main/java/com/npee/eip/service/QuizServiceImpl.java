package com.npee.eip.service;

import com.npee.eip.advice.exception.CustomQuizNotExistsException;
import com.npee.eip.advice.exception.CustomQuizTableEmptyException;
import com.npee.eip.model.entity.Item;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.repository.ItemJpaRepository;
import com.npee.eip.repository.QuizJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {

    private final QuizJpaRepository quizJpaRepository;
    private final ItemJpaRepository itemJpaRepository;

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
        return update(quizId, quizDto);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizJpaRepository.deleteById(quizJpaRepository.findById(quizId)
                .orElseThrow(CustomQuizNotExistsException::new).getQuizId());
    }

    private Quiz save(RequestQuizDto quizDto) {
        Quiz quiz = update(null, quizDto);
        quizDto.getItems().forEach(item -> quiz.addItem(item.getChoice(), item.getIsAnswer()));
        return quizJpaRepository.save(quiz);
    }

    private Quiz update(Long quizId, RequestQuizDto quizDto) {
        Quiz quiz = Quiz.builder()
                .quizId(quizId)
                .year(quizDto.getYear())
                .nth(quizDto.getNth())
                .subjectId(quizDto.getSubjectId())
                .question(quizDto.getQuestion())
                .image(quizDto.getImage())
                .build();
        if (quizId != null) {
            List<Item> items = new ArrayList<>();
            Quiz myQuiz = quizJpaRepository.findById(quizId).orElseThrow(CustomQuizNotExistsException::new);
            quizDto.getItems().forEach(item ->
                items.add(Item.builder()
                        .itemId(item.getItemId())
                        .choice(item.getChoice())
                        .isAnswer(item.getIsAnswer())
                        .itemFromQuiz(myQuiz)
                        .build())
            );
            itemJpaRepository.saveAll(items);
        }
        return quizJpaRepository.save(quiz);
    }
}
