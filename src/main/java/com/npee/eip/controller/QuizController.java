package com.npee.eip.controller;

import com.npee.eip.config.response.CommonResult;
import com.npee.eip.config.response.ListResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.service.QuizServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2. Quiz"})
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RequestMapping("/v1/quizzes")
@RequiredArgsConstructor
@Slf4j
public class QuizController {

    private final ResponseService responseService;
    private final QuizServiceImpl quizService;

    @GetMapping
    public ListResult<Quiz> getQuizList() {
        return responseService.getListResult(quizService.selectQuizzes());
    }

    @GetMapping("/{quizId}")
    public SingleResult<Quiz> getSelectedQuiz(@PathVariable Long quizId) {
        return responseService.getSingleResult(quizService.selectAQuiz(quizId));
    }

    @PostMapping
    public SingleResult<Quiz> setQuiz(@RequestBody RequestQuizDto quizDto) {
        return responseService.getSingleResult(quizService.insertQuiz(quizDto));
    }

    @PutMapping("/{quizId}")
    public SingleResult<Quiz> updateQuiz(@PathVariable Long quizId,
                                         @RequestBody RequestQuizDto quizDto) {
        return responseService.getSingleResult(quizService.updateQuiz(quizId, quizDto));
    }

    @DeleteMapping("/{quizId}")
    public CommonResult deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteQuiz(quizId);
        return responseService.getSuccessResult();
    }
}
