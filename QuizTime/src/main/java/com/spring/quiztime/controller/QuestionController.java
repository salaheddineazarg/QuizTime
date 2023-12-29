package com.spring.quiztime.controller;


import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Question.QuestionResponseDTO;
import com.spring.quiztime.service.impl.QuestionService;
import com.spring.quiztime.service.interfaces.IQuestionService;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {



    private final IQuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }
    @GetMapping
    public ResponseEntity<Page<QuestionResponseDTO>> getAll(Pageable pageable){

        return new ResponseEntity<>(questionService.getAllServicePagination(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> save(@Valid @RequestBody QuestionDTO question){

        return questionService.saveService(question)
                .map(savedQuestion -> new ResponseEntity<>(savedQuestion,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<QuestionResponseDTO> update(@Valid @RequestBody QuestionDTO question,@PathVariable Long id){

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
