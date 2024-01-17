package com.spring.quiztime.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class User {

 @Column(nullable = false)
 @NotBlank(message = "First name cannot be blank")
 private String firstName;

 @Column(nullable = false)
 @NotBlank(message = "Last name cannot be blank")
 private String lastName;

 @Temporal(TemporalType.DATE)
 private LocalDate dateBirth;

 @Column(nullable = false)
 @NotBlank(message = "Address cannot be blank")
 private String address;

}