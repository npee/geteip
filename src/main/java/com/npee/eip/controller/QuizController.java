package com.npee.eip.controller;

import com.npee.eip.advice.exception.CustomQuizNotExistsException;
import com.npee.eip.config.response.CommonResult;
import com.npee.eip.config.response.ListResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.repository.QuizJpaRepository;
import com.npee.eip.service.QuizServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"2. Quiz"})
@RestController
@RequestMapping("/v1/quizzes")
@RequiredArgsConstructor
@Slf4j
public class QuizController {

    private final ResponseService responseService;
    private final QuizJpaRepository quizJpaRepository;
    private final QuizServiceImpl quizService;

    @GetMapping
    public ListResult<Quiz> getQuizList() {
        return responseService.getListResult(quizService.selectQuizzes());
    }

    @GetMapping("/{quizId}")
    public SingleResult<Quiz> getSelectedQuiz(@PathVariable Long quizId) {

        Quiz quiz = quizJpaRepository.findById(quizId).orElseThrow(CustomQuizNotExistsException::new);
        return responseService.getSingleResult(quiz);
    }

    @PostMapping
    public SingleResult<Quiz> setQuiz(@RequestParam Long year,
                                      @RequestParam String nth) {
        Quiz quiz = Quiz.builder()
                .year(year)
                .nth(nth)
                .question("test")
                .image("empty")
                .isCorrect("false")
                .build();
        quizJpaRepository.save(quiz);
        return responseService.getSingleResult(quiz);
    }

    @PutMapping("/{quizId}")
    public SingleResult<Quiz> updateQuiz(@PathVariable Long quizId,
                                         @RequestParam Long year,
                                         @RequestParam String nth) {

        Quiz quiz = Quiz.builder()
                .quizId(quizId)
                .year(year)
                .nth(nth)
                .question("test")
                .image("empty")
                .isCorrect("false")
                .build();
        quizJpaRepository.save(quiz);
        return responseService.getSingleResult(quiz);
    }

    @DeleteMapping("/{quizId}")
    public CommonResult deleteQuiz(@PathVariable Long quizId) {
        quizJpaRepository.findById(quizId).orElseThrow(CustomQuizNotExistsException::new);
        quizJpaRepository.deleteById(quizId);
        return responseService.getSuccessResult();
    }
}
