package com.npee.eip.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
public class Subject {

    @Id
    private Long subjectId;

    @Column
    private String subject2019;

    @Column
    private String subject;

}
