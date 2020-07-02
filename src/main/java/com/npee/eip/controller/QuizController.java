package com.npee.eip.controller;

import com.npee.eip.config.response.CommonResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.entity.Subject;
import com.npee.eip.repository.QuizJpaRepository;
import com.npee.eip.repository.SubjectJpaRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

        Quiz quiz = quizJpaRepository.findById(id).get();
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
