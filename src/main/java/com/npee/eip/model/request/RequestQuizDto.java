package com.npee.eip.model.request;

import com.npee.eip.model.entity.Comment;
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
    // 과목 번호
    private Long subjectId;
    // 보기 리스트 TODO: ItemDto로 이관
    // private List<Item> itemList;
    // 해설 번호
    private Comment tempComment;

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
