package com.spring.quiztime.controller;


import com.spring.quiztime.dto.QuizDTO;
import com.spring.quiztime.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/quiz")
public class QuizController {


    @Autowired
      private QuizService quizService;


     @GetMapping
     public ResponseEntity<List<QuizDTO>> getAll(){

         return new ResponseEntity<>(quizService.getAllService(),HttpStatus.OK);
     }

    @PostMapping
    public ResponseEntity<QuizDTO> save(@Valid @RequestBody QuizDTO quizDTO){

        return quizService.saveService(quizDTO)
                .map(quizSaved -> new ResponseEntity<>(quizSaved, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizDTO> update(@Valid @RequestBody QuizDTO quizDTO , Long id){

        return quizService.updateService(quizDTO,id)
                .map(quizSaved -> new ResponseEntity<>(quizSaved, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<String> delete(@PathVariable Long id){

         if (quizService.deleteService(id)){

             return  new ResponseEntity<>("Quiz deleted successfully!.",HttpStatus.OK);
         }

        return  new ResponseEntity<>("Quiz didn't deleted!.",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getById(@PathVariable Long id){

        return quizService.findByIdService(id)
                .map(getQuiz -> new ResponseEntity<>(getQuiz,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));

    }
}