package com.spring.quiztime.controller;

import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentDTO;
import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentResponseDTO;
import com.spring.quiztime.service.AssignQuizStudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assign")
public class AssignQuizStudentController {

    @Autowired
    private AssignQuizStudentService assignQuizStudentService;

    @GetMapping
    public ResponseEntity<List<AssignQuizStudentResponseDTO>> getAll(){

        return new ResponseEntity<>(assignQuizStudentService.getAllService(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssignQuizStudentResponseDTO> save(@Valid @RequestBody AssignQuizStudentDTO assignQuizStudentDTO){

        return  assignQuizStudentService.saveService(assignQuizStudentDTO)
                .map(savedAssign -> new ResponseEntity<>(savedAssign, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("{id}")
    public ResponseEntity<AssignQuizStudentResponseDTO> update(@Valid @RequestBody AssignQuizStudentDTO assignQuizStudentDTO,@PathVariable @Min(value = 1) Long id){
        return  assignQuizStudentService.updateService(assignQuizStudentDTO,id)
                .map(savedAssign -> new ResponseEntity<>(savedAssign, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable @Min(value = 1) Long id ){
        if (assignQuizStudentService.deleteService(id)){
            return  new ResponseEntity<>("Assignemenet is deleted successfully!.",HttpStatus.OK);
        }
        return  new ResponseEntity<>("Assignemenet is didn't deleted!.",HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AssignQuizStudentResponseDTO> getById(@PathVariable @Min(value = 1) Long id){
        return  assignQuizStudentService.findByIdService(id)
                .map(savedAssign -> new ResponseEntity<>(savedAssign, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }




}
