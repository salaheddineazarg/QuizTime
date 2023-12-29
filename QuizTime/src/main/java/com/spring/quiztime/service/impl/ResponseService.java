package com.spring.quiztime.service.impl;


import com.spring.quiztime.dto.ResponseDTO;
import com.spring.quiztime.entities.Response;
import com.spring.quiztime.repository.ResponseRepository;
import com.spring.quiztime.service.interfaces.IResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements IResponseService {


    private final ResponseRepository responseRepository;

    private final ModelMapper modelMapper;

    public ResponseService(ResponseRepository responseRepository,
                           ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.responseRepository =responseRepository;
    }

    @Override
    public List<ResponseDTO> getAllService(){

        return  Arrays.asList(modelMapper.map(responseRepository.findAll(),ResponseDTO[].class));
    }

    @Override
    public Optional<ResponseDTO> saveService(ResponseDTO responseDTO) {
        Response response = modelMapper.map(responseDTO,Response.class);
        return  Optional.ofNullable(modelMapper.map(responseRepository.save(response),ResponseDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {
        if(responseRepository.existsById(Id)){

            responseRepository.deleteById(Id);

            return true;
        }
        return false;
    }

    @Override
    public Optional<ResponseDTO> updateService(ResponseDTO responseDTO, Long Id) {
        if (responseRepository.existsById(Id)){
            Response response = modelMapper.map(responseDTO,Response.class);
            response.setId(Id);
            return  Optional.ofNullable(modelMapper.map(responseRepository.save(response),ResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ResponseDTO> findByIdService(Long Id) {
        Response response = responseRepository.findById(Id).get();

        return Optional.of(modelMapper.map(response,ResponseDTO.class));
    }
}
