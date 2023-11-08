package com.spring.quiztime.service;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {


    @Autowired
    private LevelRepository levelRepository;


    public List<Level> getAllService(){

        return levelRepository.findAll();
    }

    public Optional<Level> saveService(Level level){

      return Optional.of(levelRepository.save(level));
    }

    public boolean deleteService(Long id){

        if(levelRepository.findById(id).isPresent()){
            levelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Level> updateService(Level level,Long id){
        if(levelRepository.findById(id).isPresent()){
            level.setId(id);
            return Optional.of(levelRepository.save(level));
        }
        return null;
    }

    public Optional<Level> findByIdService(Long id){

    return levelRepository.findById(id);
    }


}
