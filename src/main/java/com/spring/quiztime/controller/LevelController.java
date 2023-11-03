package com.spring.quiztime.controller;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/level")
public class LevelController {


    @Autowired
    private LevelService levelService;

    @GetMapping
    public  List<Level> getAll(){

       return levelService.getAllService();
    }

    @PostMapping
    public ResponseEntity<Level> save(@RequestBody Level level){


        return ResponseEntity.ok(levelService.saveService(level));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Level> update(@RequestBody Level level,@PathVariable("id") Long id){

     return ResponseEntity.ok(levelService.updateService(level,id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        levelService.deleteService(id);

        return ResponseEntity.ok("Level deleted successfully!.");
    }

    @GetMapping("/getLevel/{id}")
    public ResponseEntity<Optional<Level>> getById(@PathVariable("id") Long id) {

    return ResponseEntity.ok(levelService.findByIdService(id));
    }


}
