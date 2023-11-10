package com.spring.quiztime.service;


import com.spring.quiztime.entities.Subject;
import com.spring.quiztime.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {


    @Autowired
    private SubjectRepository subjectRepository;



    public List<Subject> getAllService(){

        return subjectRepository.findAll();
    }

    public Optional<Subject> saveService(Subject subject){

        return Optional.ofNullable(subjectRepository.save(subject));
    }

    public Optional<Subject> updateService(Subject subject,Long id){
        if (subjectRepository.findById(id).isPresent()){
            subject.setId(id);
           return Optional.of(subjectRepository.save(subject));
        }
        return Optional.empty();
    }

    public boolean deleteService(Long id){
        if (subjectRepository.findById(id).isPresent()){

            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Subject> findByIdService(Long id){


       return  subjectRepository.findById(id);
    }
}
