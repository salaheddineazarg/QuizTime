package com.spring.quiztime.controller;


import com.spring.quiztime.dto.QuestionDTO;
import com.spring.quiztime.dto.QuestionResponseDTO;
import com.spring.quiztime.entities.Question;
import com.spring.quiztime.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAll(){


        return new ResponseEntity<>(questionService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> save(@Valid @RequestBody QuestionDTO question){

        return questionService.saveService(question)
                .map(savedQuestion -> new ResponseEntity<>(savedQuestion,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<QuestionResponseDTO> update(@RequestBody QuestionDTO question,@PathVariable Long id){

        return questionService.updateService(question,id)
                .map(upadedQuestion -> new ResponseEntity<>(upadedQuestion,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if (questionService.deleteService(id)){
            return  new ResponseEntity<>("Question is deleted successfully !.",HttpStatus.OK);
        }
        return new ResponseEntity<>("Question didn't delete !.",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getById(@PathVariable Long id){

        return questionService.findByIdService(id)
                .map(getOne -> new ResponseEntity<>(getOne,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }
}
