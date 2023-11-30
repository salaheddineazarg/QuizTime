package com.spring.quiztime.controller;


import com.spring.quiztime.dto.TeacherDTO;
import com.spring.quiztime.service.TeacherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;



    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAll(){

        return new ResponseEntity<>(teacherService.getAllService(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<TeacherDTO> save(@Valid @RequestBody TeacherDTO teacherDTO){

         return teacherService.saveService(teacherDTO)
                 .map(savedTeacher -> new ResponseEntity<>(savedTeacher, HttpStatus.CREATED))
                 .orElse(new ResponseEntity<>(null,HttpStatus.OK));
     }

     @PutMapping("{id}")
     public ResponseEntity<TeacherDTO> update(@Valid @RequestBody TeacherDTO teacherDTO, @PathVariable @Min(value = 1) Long id){

         return teacherService.updateService(teacherDTO,id)
                 .map(savedTeacher -> new ResponseEntity<>(savedTeacher, HttpStatus.CREATED))
                 .orElse(new ResponseEntity<>(null,HttpStatus.OK));
     }

     @DeleteMapping("{id}")
     public ResponseEntity<String> delete(@PathVariable @Min(value = 1) Long id){

        if (teacherService.deleteService(id)){

            return new ResponseEntity<>("Teacher is deleted successfully!",HttpStatus.OK);
        }
         return new ResponseEntity<>("Teacher is didn't deleted",HttpStatus.NOT_FOUND);
     }

     @GetMapping("{id}")
     public ResponseEntity<TeacherDTO> getById(@PathVariable @Min(value = 1) Long id){

         return teacherService.findByIdService(id)
                 .map(savedTeacher -> new ResponseEntity<>(savedTeacher, HttpStatus.CREATED))
                 .orElse(new ResponseEntity<>(null,HttpStatus.OK));
     }
}
