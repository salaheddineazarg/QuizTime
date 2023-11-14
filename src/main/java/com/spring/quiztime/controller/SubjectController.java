package com.spring.quiztime.controller;

import com.spring.quiztime.dto.SubjectDTO;
import com.spring.quiztime.dto.SubjectResponseDTO;
import com.spring.quiztime.entities.Subject;
import com.spring.quiztime.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/subject")
public class SubjectController {


    @Autowired
    private SubjectService subjectService;


    @GetMapping
    public  ResponseEntity<List<SubjectResponseDTO>> getAll(){

        return new ResponseEntity<>(subjectService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> save(@RequestBody SubjectDTO subject){

        System.out.println(subject);
        return subjectService.saveService(subject)
                .map(savedSubject -> new ResponseEntity<>(savedSubject,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectResponseDTO> update(@RequestBody SubjectDTO subject,@PathVariable Long id){


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
