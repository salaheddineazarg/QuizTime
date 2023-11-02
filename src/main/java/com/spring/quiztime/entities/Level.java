package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 50)
    private String name;

    @Column()
    private int maxPoints;

    @Column(name = "minPoints")
    private int minPoints;

    @OneToMany (fetch = FetchType.LAZY,mappedBy = "level")
    private List<Question> questions;


}
