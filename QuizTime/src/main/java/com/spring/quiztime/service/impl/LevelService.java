package com.spring.quiztime.service.impl;


import com.spring.quiztime.dto.LevelDTO;
import com.spring.quiztime.entities.Level;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.service.interfaces.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LevelService implements ILevelService {



    private final LevelRepository levelRepository;

    private final ModelMapper modelMapper;

    public LevelService(LevelRepository levelRepository,
                        ModelMapper modelMapper){
        this.levelRepository=levelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LevelDTO> getAllService(){

        return Arrays.asList(modelMapper.map(levelRepository.findAll(),LevelDTO[].class));
    }
    @Override
    public Optional<LevelDTO> saveService(LevelDTO levelDTO){
        Level level = modelMapper.map(levelDTO, Level.class);
        level = levelRepository.save(level);

        return  Optional.of(modelMapper.map(level,LevelDTO.class));

    }
    @Override
    public boolean deleteService(Long Id){

        if(levelRepository.existsById(Id)){
            levelRepository.deleteById(Id);
            return true;
        }
        return false;
    }
    @Override
    public Optional<LevelDTO> updateService(LevelDTO levelDTO,Long Id){
        if(levelRepository.existsById(Id)){
            Level level = modelMapper.map(levelDTO, Level.class);
              level.setId(Id);
           return Optional.of(modelMapper.map(levelRepository.save(level),LevelDTO.class));
        }
        return null;
    }
    @Override
    public Optional<LevelDTO> findByIdService(Long Id){

       LevelDTO levelDTO =  modelMapper.map(levelRepository.findById(Id),LevelDTO.class);
        levelDTO.setQuestions(levelDTO.getQuestions());
    return Optional.of(levelDTO);
    }


}
