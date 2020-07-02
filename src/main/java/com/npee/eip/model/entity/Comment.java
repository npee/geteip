package com.npee.eip.model.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = true)
    private String image;

    @OneToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz commentFromQuiz;

}
