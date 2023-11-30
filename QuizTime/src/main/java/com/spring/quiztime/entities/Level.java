package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;


import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column
    private int maxPoints;

    @Column
    private int minPoints;

    @OneToMany (fetch = FetchType.LAZY,mappedBy = "level")
    private List<Question> questions;


}
