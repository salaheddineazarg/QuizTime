package com.spring.quiztime.controller;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/level")
public class LevelController {


    @Autowired
    private LevelService levelService;

    @GetMapping
    public  ResponseEntity<List<Level>> getAll(){

       return new ResponseEntity<>(levelService.getAllService(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Level> save(@RequestBody Level level) {
        return levelService.saveService(level)
                .map(savedLevel -> new ResponseEntity<>(savedLevel, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null, HttpStatus.OK));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Level> update(@RequestBody Level level,@PathVariable("id") Long id){
        return levelService.updateService(level,id)
                .map(updatedLevel -> new ResponseEntity<>(updatedLevel, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        if (levelService.deleteService(id)){
            return  new ResponseEntity<>("Level deleted successfully!.",HttpStatus.OK);
        }

         return new ResponseEntity<>("Level didn't deleted!.",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getLevel/{id}")
    public ResponseEntity<Level> getById(@PathVariable("id") Long id) {

    return levelService.findByIdService(id)
            .map(OneLevel -> new ResponseEntity<>(OneLevel,HttpStatus.OK) )
            .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }


}
