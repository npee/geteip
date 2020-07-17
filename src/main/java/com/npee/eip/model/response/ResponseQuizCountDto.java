package com.npee.eip.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuizCountDto {
    public Long year;
    public String nth;
    public Long subjectId;
    public Long count;
}
