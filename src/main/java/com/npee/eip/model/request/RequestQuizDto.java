package com.npee.eip.model.request;

import com.npee.eip.model.entity.Quiz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestQuizDto {
    private Long year;
    private String nth;
    private String question;
    private String image;
    private String isCorrect;

    public Quiz toEntity() {
        return Quiz.builder()
                .year(year)
                .nth(nth)
                .question(question)
                .image(image)
                .isCorrect(isCorrect)
                .build();
    }
}
