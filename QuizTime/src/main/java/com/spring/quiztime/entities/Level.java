package com.spring.quiztime.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name length must be less than or equal to 50 characters")
    private String name;

    @Min(value = 0, message = "Max points should be a non-negative number")
    private int maxPoints;

    @Min(value = 0, message = "Min points should be a non-negative number")
    private int minPoints;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level",orphanRemoval = true)
    private List<Question> questions;

  ;

}
