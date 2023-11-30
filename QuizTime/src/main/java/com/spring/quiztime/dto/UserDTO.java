package com.spring.quiztime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDTO {

 @NotBlank(message = "First name can't be blank")
 private String firstName;

 @NotBlank(message = "Last name can't be blank")
 private String lastName;

 @NotNull(message = "Date of birth can't be null")
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateBirth;

 @NotBlank(message = "Address can't be blank")
 private String address;
}
