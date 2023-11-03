package com.spring.quiztime.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class ValidationId implements Serializable {

    private Response response;

    private Question question;

}
