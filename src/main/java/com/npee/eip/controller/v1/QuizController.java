package com.npee.eip.controller.v1;

import com.npee.eip.config.response.*;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.model.response.ResponseQuizCountDto;
import com.npee.eip.service.QuizServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
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

    @ApiOperation(value = "퀴즈 목록 출력", notes = "모든 퀴즈 목록을 조회한다.")
    @GetMapping
    public ListResult<Quiz> getQuizList() {
        return responseService.getListResult(quizService.selectQuizzes());
    }

    @ApiOperation(value = "조건에 맞는 퀴즈 목록 출력", notes = "조건에 맞는 퀴즈 목록을 조회한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping("/page")
    public PageResult<Quiz> getRetrieveQuizList(final Pageable pageable) {
        return responseService.getPageResult(quizService.retrieveQuizzes(pageable));
    }

    @ApiOperation(value = "퀴즈 단일 출력", notes = "퀴즈 하나를 조회한다.")
    @GetMapping("/{quizId}")
    public SingleResult<Quiz> getSelectedQuiz(@PathVariable Long quizId) {
        return responseService.getSingleResult(quizService.selectAQuiz(quizId));
    }

    @ApiOperation(value = "회차별 퀴즈 개수 출력", notes = "회차별 과목에 등록된 퀴즈의 개수를 조회한다.")
    @GetMapping("/count")
    public ListResult<ResponseQuizCountDto> findQuizzesByYearAndNthAndSubjectId() {
        return responseService.getListResult(quizService.countByYearAndNthAndSubjectIdAtSelectedAllQuiz());
    }

    @ApiOperation(value = "퀴즈 입력", notes = "퀴즈 하나를 등록한다.")
    @PostMapping
    public SingleResult<Quiz> setQuiz(
            @ApiParam(value = "퀴즈 내용", required = true) @RequestBody RequestQuizDto quizDto) {
        return responseService.getSingleResult(quizService.insertQuiz(quizDto));
    }

    @ApiOperation(value = "퀴즈 수정", notes = "퀴즈 하나를 수정한다.")
    @PutMapping("/{quizId}")
    public SingleResult<Quiz> updateQuiz(
            @PathVariable Long quizId,
            @ApiParam(value = "퀴즈 내용", required = true) @RequestBody RequestQuizDto quizDto) {
        return responseService.getSingleResult(quizService.updateQuiz(quizId, quizDto));
    }

    @ApiOperation(value = "퀴즈 제거", notes = "퀴즈 하나를 삭제한다.")
    @DeleteMapping("/{quizId}")
    public CommonResult deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteQuiz(quizId);
        return responseService.getSuccessResult();
    }
}
