package com.npee.eip.model.entity;

import com.npee.eip.model.entity.common.BaseTime;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
public class Quiz extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private String nth;

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

    @ManyToOne
    @JoinColumn(name = "SUBJECT_NO")
    private Subject quizFromSubject;

    @OneToMany(mappedBy = "itemFromQuiz")
    private List<Item> items;

}
