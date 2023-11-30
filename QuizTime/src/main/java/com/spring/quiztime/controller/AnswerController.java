package com.spring.quiztime.controller;


import com.spring.quiztime.dto.Answer.AnswerDTO;
import com.spring.quiztime.dto.Answer.AnswerResponseDTO;
import com.spring.quiztime.service.AnswerService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerController {


    @Autowired
    private AnswerService answerService;


    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> getAll(){

        return new ResponseEntity<>(answerService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnswerResponseDTO> save(@RequestBody AnswerDTO answerDTO){

        return answerService.saveService(answerDTO)
                .map(savedAnswer -> new ResponseEntity<>(savedAnswer,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@Min(value = 1) @PathVariable Long id){
        if (answerService.deleteService(id)){
            return new ResponseEntity<>("Answer is deleted successfuly!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Answer is didn't deleted !",HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<AnswerResponseDTO> update(@RequestBody AnswerDTO answerDTO,@Min(value = 1) @PathVariable Long id){

        return answerService.updateService(answerDTO,id)
                .map(savedAnswer -> new ResponseEntity<>(savedAnswer,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<AnswerResponseDTO> getById(@Min(value = 1) @PathVariable Long id){

        return answerService.findByIdService(id)
                .map(savedAnswer -> new ResponseEntity<>(savedAnswer,HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

}
