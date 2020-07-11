package com.npee.eip.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false, length = 100)
    private String choice;

    @Column(nullable = false)
    private String isAnswer;

    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    @JsonBackReference
    private Quiz itemFromQuiz;

}
