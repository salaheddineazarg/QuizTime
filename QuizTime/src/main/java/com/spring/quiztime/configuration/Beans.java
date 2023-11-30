package com.spring.quiztime.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Configuration
public class Beans {


    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }


}
