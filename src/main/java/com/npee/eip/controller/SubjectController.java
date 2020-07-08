package com.npee.eip.controller;

import com.npee.eip.advice.exception.CustomSubjectNotExistsException;
import com.npee.eip.config.response.ListResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Subject;
import com.npee.eip.repository.SubjectJpaRepository;
import com.npee.eip.service.SubjectServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"3. Subject"})
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
@Slf4j
public class SubjectController {

    private final ResponseService responseService;
    private final SubjectServiceImpl subjectService;
    private final SubjectJpaRepository subjectJpaRepository;

    @GetMapping
    public ListResult<Subject> getSubjectList() {
        return responseService.getListResult(subjectService.selectSubjects());
    }

    // TODO: 로직을 서비스 내부로 이동
    @GetMapping("/{subjectNo}")
    public SingleResult<Subject> getSelectedSubject(@PathVariable Long subjectNo) {
        Subject subject = subjectJpaRepository.findById(subjectNo).orElseThrow(CustomSubjectNotExistsException::new);
        return responseService.getSingleResult(subject);
    }
}
