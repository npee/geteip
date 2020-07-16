package com.npee.eip.model.request;

import com.npee.eip.model.entity.Comment;
import com.npee.eip.model.entity.Item;
import com.npee.eip.model.entity.Quiz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RequestQuizDto {
    private Long year;
    private String nth;
    private String question;
    private String image;
    // 과목 번호
    private Long subjectId;
    // 보기 리스트
    private List<Item> items = new ArrayList<>();
    // 해설 번호
    private Comment tempComment;
}
