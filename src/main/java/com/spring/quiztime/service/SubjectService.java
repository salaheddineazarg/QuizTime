package com.spring.quiztime.service;


import com.spring.quiztime.entities.Subject;
import com.spring.quiztime.repository.SubjectRepository;
import com.spring.quiztime.service.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {


    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAllService(){

        return subjectRepository.findAll();
    }
    @Override
    public Optional<Subject> saveService(Subject subject){

        return Optional.ofNullable(subjectRepository.save(subject));
    }
    @Override
    public Optional<Subject> updateService(Subject subject,Long id){
        if (subjectRepository.findById(id).isPresent()){
            subject.setId(id);
           return Optional.of(subjectRepository.save(subject));
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteService(Long id){
        if (subjectRepository.findById(id).isPresent()){

            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Optional<Subject> findByIdService(Long id){


       return  subjectRepository.findById(id);
    }
}
