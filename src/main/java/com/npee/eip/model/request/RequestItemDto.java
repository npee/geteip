package com.npee.eip.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestItemDto {
    // private Long quizId;
    private String choice;
    private String isAnswer;
}
