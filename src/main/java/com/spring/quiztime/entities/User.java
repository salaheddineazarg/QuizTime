package com.spring.quiztime.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class User {
   @Column(nullable = false,length = 50)
    private String firstName;

    @Column(nullable = false,length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate dateBirth;

    @Column(nullable = false,length = 50)
    private String address;
}
