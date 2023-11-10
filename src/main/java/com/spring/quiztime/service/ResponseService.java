package com.spring.quiztime.service;


import com.spring.quiztime.entities.Response;
import com.spring.quiztime.repository.ResponseRepository;
import com.spring.quiztime.service.interfaces.IResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements IResponseService {

    @Autowired
    private ResponseRepository responseRepository;


    @Override
    public List<Response> getAllService() {

        return responseRepository.findAll();
    }

    @Override
    public Optional<Response> saveService(Response response) {

        return Optional.of(responseRepository.save(response));
    }

    @Override
    public boolean deleteService(Long id) {
        if (responseRepository.findById(id).isPresent()) {
            responseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Response> updateService(Response response, Long id) {
        if (responseRepository.findById(id).isPresent()) {
            response.setId(id);
            return Optional.of(responseRepository.save(response));
        }
        return null;
    }

    @Override
    public Optional<Response> findByIdService(Long id) {

        return responseRepository.findById(id);
    }

}
