package com.spring.quiztime.controller;


import com.spring.quiztime.dto.StudentDTO;
import com.spring.quiztime.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(){

        return new  ResponseEntity<>(studentService.getAllService(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody  StudentDTO studentDTO){

        return studentService.saveService(studentDTO)
                .map(saveStudent -> new ResponseEntity<>(saveStudent, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable @Min(value = 1) Long id){
        if(studentService.deleteService(id)){

            return new ResponseEntity<>("Student is deleted successfully!.",HttpStatus.OK);
        }

        return new ResponseEntity<>("Student is didn't deleted",HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO studentDTO,@PathVariable @Min(value = 1) Long id){

        return studentService.updateService(studentDTO,id)
                .map(saveStudent -> new ResponseEntity<>(saveStudent, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getAll(@PathVariable @Min(value = 1) Long id){

        return studentService.findByIdService(id)
                .map(saveStudent -> new ResponseEntity<>(saveStudent, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }
}
