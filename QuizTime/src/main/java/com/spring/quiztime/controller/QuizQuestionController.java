package com.spring.quiztime.controller;


import com.spring.quiztime.dto.QuizQuestion.QuizQuestionDTO;
import com.spring.quiztime.dto.QuizQuestion.QuizQuestionResponseDTO;
import com.spring.quiztime.service.impl.QuizQuestionService;
import com.spring.quiztime.service.interfaces.IQuizQuestionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affect-question-quiz")
public class QuizQuestionController {



    private final IQuizQuestionService quizQuestionService;

     public QuizQuestionController(QuizQuestionService quizQuestionService){
         this.quizQuestionService =quizQuestionService;
     }

    @GetMapping
    public ResponseEntity<List<QuizQuestionResponseDTO>> getAll(){

        return new ResponseEntity<>(quizQuestionService.getAllService(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<List<QuizQuestionResponseDTO>> save(@Valid @RequestBody List<QuizQuestionDTO> quizQuestionDTOS){

        List<QuizQuestionResponseDTO> questionResponseDTOList = quizQuestionService.saveAllService(quizQuestionDTOS);

        return new ResponseEntity<>(questionResponseDTOList,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<QuizQuestionResponseDTO> update(@Valid @RequestBody QuizQuestionDTO questionDTO, @Min(value = 1) Long id){
        return quizQuestionService.updateService(questionDTO,id)
                .map(updateQuizQuestion ->new ResponseEntity<>(updateQuizQuestion,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@Min(value = 1) Long id){
        if (quizQuestionService.deleteService(id)){

            return new ResponseEntity<>("Affectation is deleted successfully!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Affectation is didn't deleted",HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuizQuestionResponseDTO> getById(@Min(value = 1) Long id){

        return quizQuestionService.findByIdService(id)
                .map(quizQuestion -> new ResponseEntity<>(quizQuestion,HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }
    @GetMapping("by-quiz/{id}")
    public ResponseEntity<List<QuizQuestionResponseDTO>> getByQuiz(@PathVariable @Min(value = 1) Long id){

        return new ResponseEntity<>(quizQuestionService.findBYQuizId(id),HttpStatus.FOUND);
    }
}
