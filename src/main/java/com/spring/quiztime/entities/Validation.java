package com.spring.quiztime.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Validation {

    @EmbeddedId
    private ValidationId validationID;

    @ManyToOne
    @JoinColumn(name = "Response_id")
    private Response response;

    @ManyToOne
    @JoinColumn(name = "Question_id")
    private Question question;

    private double points;

}
