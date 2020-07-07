package com.npee.eip.service;

import com.npee.eip.model.entity.Subject;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.repository.SubjectJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Subject insertSubject(RequestQuizDto quizDto) {
        return null;
    }

    @Override
    public List<Subject> selectSubjects() {
        return subjectJpaRepository.findAll();
    }

    @Override
    public Subject selectASubject(Long subjectId) {
        return null;
    }

    @Override
    public Subject updateSubject(Long subjectId, RequestQuizDto quizDto) {
        return null;
    }

    @Override
    public void deleteSubject(Long subjectId) {

    }
}
