package com.npee.eip.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.npee.eip.model.entity.common.BaseTime;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
@Slf4j
public class Quiz extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private String nth;

    @Column(nullable = false)
    private Long subjectId;

    @Column(nullable = false, length = 100)
    private String question;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private String isCorrect;

    // @Column(nullable = false)
    // private Long countCorrect;

    // @Column(nullable = false)
    // private Long countIncorrect;

    @OneToOne(mappedBy = "commentFromQuiz")
    private Comment quizFromComment;

    @OneToMany(mappedBy = "itemFromQuiz", cascade = CascadeType.ALL)
    @JsonManagedReference
    private final List<Item> items = new ArrayList<>();

    public void addItem(String choice, String isAnswer) {
        items.add(new Item(choice, isAnswer, this));
    }
}
