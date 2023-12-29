package com.spring.quiztime.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Subject  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @ManyToOne
    private Subject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Subject> childs;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Question> questions;
}
