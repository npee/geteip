package com.npee.eip.controller;

import com.npee.eip.advice.exception.CustomQuizNotExistsException;
import com.npee.eip.config.response.CommonResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.repository.QuizJpaRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Api(tags = {"2. Quiz"})
@RestController
@RequestMapping("/v1/quiz")
@RequiredArgsConstructor
@Slf4j
public class QuizController {

    private final ResponseService responseService;
    private final QuizJpaRepository quizJpaRepository;


    @GetMapping
    public CommonResult getQuizList() {
        return responseService.getSuccessResult();
    }

    @GetMapping("/{id}")
    public SingleResult<Quiz> getSelectedQuiz(@PathVariable Long id) {

        Quiz quiz = quizJpaRepository.findById(id).orElseThrow(CustomQuizNotExistsException::new);
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
                .regDate(LocalDateTime.now().plusHours(6L))
                .modDate(LocalDateTime.now().plusHours(6L))
                .build();
        quizJpaRepository.save(quiz);

        return responseService.getSingleResult(quiz);
    }
}
