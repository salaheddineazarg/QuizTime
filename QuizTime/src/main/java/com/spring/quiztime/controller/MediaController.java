package com.spring.quiztime.controller;


import com.spring.quiztime.dto.Media.MediaDTO;
import com.spring.quiztime.service.impl.MediaService;
import com.spring.quiztime.service.interfaces.IMediaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/media")
public class MediaController {



    private final IMediaService mediaService;


    public MediaController(MediaService mediaService){
        this.mediaService=mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaDTO>> getAll(){

        return new ResponseEntity<>(mediaService.getAllService(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MediaDTO> save(@Valid @RequestBody MediaDTO mediaDTO){

        return mediaService.saveService(mediaDTO)
                .map(mediaDto -> new ResponseEntity<>(mediaDto,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@Min(value = 1) Long id){

        if (mediaService.deleteService(id)){
            return new ResponseEntity<>("Media is deleted successfuly !",HttpStatus.OK);
        }
        return new ResponseEntity<>("Media didn't delted",HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<MediaDTO> update(@Valid @RequestBody MediaDTO mediaDTO,@Min(value = 1) Long id){

        return mediaService.updateService(mediaDTO,id)
                .map(mediaDto ->new ResponseEntity<>(mediaDto,HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(null,HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<MediaDTO> getById(@Min(value = 1) Long id){

        return mediaService.findByIdService(id)
                .map(mediaDto ->new ResponseEntity<>(mediaDto,HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }
}
