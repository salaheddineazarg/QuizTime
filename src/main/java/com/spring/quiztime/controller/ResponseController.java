package com.spring.quiztime.controller;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.entities.Response;
import com.spring.quiztime.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public  List<Response> getAll(){

        return responseService.getAllService();
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Response response){


        return ResponseEntity.ok(responseService.saveService(response));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> update(@RequestBody Response response,@PathVariable("id") Long id){

        return ResponseEntity.ok(responseService.updateService(response,id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        responseService.deleteService(id);

        return ResponseEntity.ok("Response deleted successfully!.");
    }

    @GetMapping("/getResponse/{id}")
    public ResponseEntity<Optional<Response>> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(responseService.findByIdService(id));
    }
}
