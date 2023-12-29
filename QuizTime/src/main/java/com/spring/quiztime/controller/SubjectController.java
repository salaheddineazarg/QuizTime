package com.spring.quiztime.controller;

import com.spring.quiztime.dto.Subject.SubjectDTO;
import com.spring.quiztime.dto.Subject.SubjectResponseDTO;
import com.spring.quiztime.service.impl.SubjectService;
import com.spring.quiztime.service.interfaces.ISubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {



    private final ISubjectService subjectService;


    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping
    public  ResponseEntity<List<SubjectResponseDTO>> getAll(){

        return new ResponseEntity<>(subjectService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> save(@Valid @RequestBody SubjectDTO subject){

        System.out.println(subject);
        return subjectService.saveService(subject)
                .map(savedSubject -> new ResponseEntity<>(savedSubject,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectResponseDTO> update(@Valid @RequestBody SubjectDTO subject,@PathVariable Long id){


        return subjectService.updateService(subject,id)
                .map(updatedSubject -> new ResponseEntity<>(updatedSubject,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if (subjectService.deleteService(id)){

            return new ResponseEntity<>("Subject is deleted successfully!.",HttpStatus.OK);
        };

        return new ResponseEntity<>("Subject is doesn't delete !.",HttpStatus.NOT_FOUND) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getById(@PathVariable Long id) {

        return subjectService.findByIdService(id)
                .map(OneSubject -> new ResponseEntity<>(OneSubject,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

}
