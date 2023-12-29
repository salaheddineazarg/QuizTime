package com.spring.quiztime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDTO {

 @NotBlank(message = "First name cannot be blank")
 private String firstName;

 @NotBlank(message = "Last name cannot be blank")
 private String lastName;

 @NotNull(message = "Date of birth cannot be null")
 @Past(message = "Date of birth should be in the past")
 private LocalDate dateBirth;

 @NotBlank(message = "Address cannot be blank")
 @Size( message = "Address length should be less than or equal to 100 characters")
 private String address;
}
