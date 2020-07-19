package com.npee.eip.repository;

import com.npee.eip.model.entity.Quiz;
import com.npee.eip.model.response.ResponseQuizCountDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuizJpaRepositoryTest {

    @Autowired
    private QuizJpaRepository quizJpaRepository;

    @Test
    public void 퀴즈_개수_조회_테스트() {
        List<Quiz> quizList = new ArrayList<>();
        Quiz quiz1 = Quiz.builder().year(2017L).nth("3rd").subjectId(2L).question("문제1").build();
        Quiz quiz2 = Quiz.builder().year(2017L).nth("3rd").subjectId(2L).question("문제2").build();
        Quiz quiz3 = Quiz.builder().year(2017L).nth("3rd").subjectId(2L).question("문제3").build();
        Quiz quiz4 = Quiz.builder().year(2018L).nth("2nd").subjectId(5L).question("문제4").build();
        quizList.add(quiz1);
        quizList.add(quiz2);
        quizList.add(quiz3);
        quizList.add(quiz4);
        List<Quiz> savedQuizList = quizJpaRepository.saveAll(quizList);
        List<ResponseQuizCountDto> dtoList = quizJpaRepository.selectQuizCountByYearAndNthAndSubjectId();
        assertThat(dtoList, is(notNullValue()));
        assertThat(dtoList, hasItems());
    }
}
