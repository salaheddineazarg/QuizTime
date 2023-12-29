package com.spring.quiztime.controller;


import com.spring.quiztime.dto.Validation.ValidationDTO;
import com.spring.quiztime.dto.Validation.ValidationResponseDTO;
import com.spring.quiztime.service.impl.ValidationService;
import com.spring.quiztime.service.interfaces.IValidationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/validation")
public class ValidationController {


    private final IValidationService validationService;


    public ValidationController(ValidationService validationService){
        this.validationService = validationService;
    }

    @GetMapping
    private ResponseEntity<List<ValidationResponseDTO>> getAll(){

        return new ResponseEntity<>(validationService.getAllService(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ValidationResponseDTO>> save(@Valid @RequestBody List<ValidationDTO> validationDTOs){

        List<ValidationResponseDTO> savedValidations = validationService.saveAllService(validationDTOs);

        return new ResponseEntity<>(savedValidations, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@Min(value = 1) @PathVariable Long id){

        if (validationService.deleteService(id)){

            return new ResponseEntity<>("Validation is deleted successfully!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Validation is didn't deleted",HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<ValidationResponseDTO> update(@Valid @RequestBody ValidationDTO validationDTO,@Min(value = 1) @PathVariable Long id){
        return validationService.updateService(validationDTO,id)
                .map(savedValidation -> new ResponseEntity<>(savedValidation,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<ValidationResponseDTO> getById(@Min(value = 1) @PathVariable Long id){

        return validationService.findByIdService(id)
                .map(savedValidation -> new ResponseEntity<>(savedValidation,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }
}
