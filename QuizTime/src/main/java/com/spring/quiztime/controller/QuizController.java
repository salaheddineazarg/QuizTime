package com.spring.quiztime.controller;


import com.spring.quiztime.dto.Quiz.QuizDTO;
import com.spring.quiztime.dto.Quiz.QuizResponseDTO;
import com.spring.quiztime.service.impl.QuizService;
import com.spring.quiztime.service.interfaces.IQuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {


      private final IQuizService quizService;

        public QuizController(QuizService quizService){
            this.quizService = quizService;
        }


     @GetMapping
     public ResponseEntity<List<QuizResponseDTO>> getAll(){

         return new ResponseEntity<>(quizService.getAllService(),HttpStatus.OK);
     }

    @PostMapping
    public ResponseEntity<QuizResponseDTO> save(@Valid @RequestBody QuizDTO quizDTO){
        System.out.println("quiz:"+quizDTO);
        return quizService.saveService(quizDTO)
                .map(quizSaved -> new ResponseEntity<>(quizSaved, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> update(@Valid @RequestBody QuizDTO quizDTO , Long id){

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
    public ResponseEntity<QuizResponseDTO> getById(@PathVariable Long id){

        return quizService.findByIdService(id)
                .map(getQuiz -> new ResponseEntity<>(getQuiz,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));

    }
}
