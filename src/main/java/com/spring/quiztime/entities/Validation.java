package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Validation {

    @Id
    @ManyToOne
    @JoinColumn(name = "Response_id")
    private Response response;

    @Id
    @ManyToOne
    @JoinColumn(name = "Question_id")
    private Question question;

    private double points;

}
