package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Validation {


    @Id
    @ManyToOne
    private Response response;

    @Id
    @ManyToOne
    private Question question;

    private double points;

}
