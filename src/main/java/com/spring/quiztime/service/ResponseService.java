package com.spring.quiztime.service;

import com.spring.quiztime.entities.Level;
import com.spring.quiztime.entities.Response;
import com.spring.quiztime.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;



    public List<Response> getAllService(){

        return responseRepository.findAll();
    }

    public Response saveService(Response response){

        return responseRepository.save(response);
    }

    public void deleteService(Long id){

        responseRepository.deleteById(id);
    }

    public Response updateService(Response response,Long id){
        if(responseRepository.findById(id).isPresent()){
            response.setId(id);
            return responseRepository.save(response);
        }
        return null;
    }

    public Optional<Response> findByIdService(Long id){

        return responseRepository.findById(id);
    }

}
