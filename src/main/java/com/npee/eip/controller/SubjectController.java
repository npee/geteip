package com.npee.eip.controller;

import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.entity.Subject;
import com.npee.eip.repository.SubjectJpaRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;

@Api(tags = {"3. Subject"})
@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
@Slf4j
public class SubjectController {

    private final ResponseService responseService;
    private final SubjectJpaRepository subjectJpaRepository;

    @GetMapping("/{subjectNo}")
    public SingleResult<Subject> getSelectedSubject(@PathVariable Long subjectNo) {

        Subject subject = subjectJpaRepository.findById(subjectNo).get();
        return responseService.getSingleResult(subject);
    }
}
