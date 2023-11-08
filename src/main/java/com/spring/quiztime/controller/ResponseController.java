package com.spring.quiztime.controller;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.entities.Response;
import com.spring.quiztime.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;



    @GetMapping
    public  ResponseEntity<List<Response>> getAll(){

        return new ResponseEntity<>(responseService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Response response){


        return responseService.saveService(response)
                .map(savedRespone -> new ResponseEntity<>(savedRespone,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> update(@RequestBody Response response,@PathVariable("id") Long id){


        return responseService.updateService(response,id)
                .map(updatedRespone -> new ResponseEntity<>(updatedRespone,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        if (responseService.deleteService(id)){

            return new ResponseEntity<>("Response is deleted successfully!.",HttpStatus.OK);
        };

        return new ResponseEntity<>("Response is doesn't delete !.",HttpStatus.NOT_FOUND) ;
    }

    @GetMapping("/getResponse/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Long id) {

        return responseService.findByIdService(id)
                .map(OneResponse -> new ResponseEntity<>(OneResponse,HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.CONFLICT));
    }
}
