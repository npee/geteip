package com.npee.eip.service;

import com.npee.eip.model.entity.Subject;
import com.npee.eip.model.request.RequestQuizDto;

import java.util.List;

public interface SubjectService {
    Subject insertSubject(RequestQuizDto quizDto);
    List<Subject> selectSubjects();
    Subject selectASubject(Long subjectId);
    Subject updateSubject(Long subjectId, RequestQuizDto quizDto);
    void deleteSubject(Long subjectId);
}
