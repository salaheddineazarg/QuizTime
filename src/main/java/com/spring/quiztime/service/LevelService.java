package com.spring.quiztime.service;


import com.spring.quiztime.entities.Level;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.service.interfaces.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService implements ILevelService {


    @Autowired
    private LevelRepository levelRepository;

    @Override
    public List<Level> getAllService(){

        return levelRepository.findAll();
    }
    @Override
    public Optional<Level> saveService(Level level){

      return Optional.of(levelRepository.save(level));
    }
    @Override
    public boolean deleteService(Long id){

        if(levelRepository.findById(id).isPresent()){
            levelRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Optional<Level> updateService(Level level,Long id){
        if(levelRepository.findById(id).isPresent()){
            level.setId(id);
            return Optional.of(levelRepository.save(level));
        }
        return null;
    }
    @Override
    public Optional<Level> findByIdService(Long id){

    return levelRepository.findById(id);
    }


}
