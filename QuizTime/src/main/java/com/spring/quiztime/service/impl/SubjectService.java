package com.spring.quiztime.service.impl;


import com.spring.quiztime.dto.Subject.SubjectDTO;
import com.spring.quiztime.dto.Subject.SubjectResponseDTO;
import com.spring.quiztime.entities.Subject;
import com.spring.quiztime.repository.SubjectRepository;
import com.spring.quiztime.service.interfaces.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {



    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectService(SubjectRepository subjectRepository,
                          ModelMapper modelMapper){
        this.subjectRepository = subjectRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<SubjectResponseDTO> getAllService() {
        return Arrays.asList(modelMapper.map(subjectRepository.findAll(),SubjectResponseDTO[].class));
    }

    @Override
    public Optional<SubjectResponseDTO> saveService(SubjectDTO subjectDTO) {

        Subject subject = modelMapper.map(subjectDTO,Subject.class);


        if(subjectDTO.getParent_id() != null){
            subject.setParent(subjectRepository.findById(
                    subjectDTO.getParent_id()
            ).get());
        }
        subject = subjectRepository.save(subject);

        return Optional.of(modelMapper.map(subject,SubjectResponseDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {

        if(subjectRepository.existsById(Id)){
            subjectRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<SubjectResponseDTO> updateService(SubjectDTO subjectDTO, Long Id) {
        if (subjectRepository.existsById(Id)){
            Subject subject = modelMapper.map(subjectDTO,Subject.class);


            if(subjectDTO.getParent_id() != null){
                subject.setParent(subjectRepository.findById(
                        subjectDTO.getParent_id()
                ).get());
            }
            subject.setId(Id);
              subject = subjectRepository.save(subject);
            return Optional.of(modelMapper.map(subject,SubjectResponseDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public Optional<SubjectResponseDTO> findByIdService(Long Id) {

        Subject subject = subjectRepository.findById(Id).get();

        if(subject != null){

            SubjectResponseDTO subjectResponseDTO = modelMapper.map(subject, SubjectResponseDTO.class);
            subjectResponseDTO.setQuestions(subjectResponseDTO.getQuestions());
            return Optional.of(subjectResponseDTO);
        }

        return  Optional.empty();
    }
}
