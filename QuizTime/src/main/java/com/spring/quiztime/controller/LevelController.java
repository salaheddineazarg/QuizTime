package com.spring.quiztime.controller;


import com.spring.quiztime.dto.LevelDTO;
import com.spring.quiztime.service.impl.LevelService;
import com.spring.quiztime.service.interfaces.ILevelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping("/api/level")
public class LevelController {



    private final ILevelService levelService;


    public LevelController(LevelService levelService){
        this.levelService = levelService;
    }

    @GetMapping
    public  ResponseEntity<List<LevelDTO>> getAll(){

       return new ResponseEntity<>(levelService.getAllService(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LevelDTO> save(@Valid  @RequestBody LevelDTO level)   {
        return levelService.saveService(level)
                .map(savedLevel -> new ResponseEntity<>(savedLevel, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null, HttpStatus.OK));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<LevelDTO> update(@Valid @RequestBody LevelDTO level, @PathVariable Long id){
        return levelService.updateService(level,id)
                .map(updatedLevel -> new ResponseEntity<>(updatedLevel, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if (levelService.deleteService(id)){
            return  new ResponseEntity<>("Level deleted successfully!.",HttpStatus.OK);
        }

         return new ResponseEntity<>("Level didn't deleted!.",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelDTO> getById(@PathVariable Long id) {

    return levelService.findByIdService(id)
            .map(OneLevel -> new ResponseEntity<>(OneLevel,HttpStatus.OK) )
            .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }


}
