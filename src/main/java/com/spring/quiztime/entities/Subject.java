package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 255)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Subject parent;

    @OneToMany(mappedBy = "parent")
    private List<Subject> childs;
}
