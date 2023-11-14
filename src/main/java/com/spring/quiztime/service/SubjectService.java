package com.spring.quiztime.service;


import com.spring.quiztime.dto.QuestionResponseDTO;
import com.spring.quiztime.dto.SubjectDTO;
import com.spring.quiztime.dto.SubjectResponseDTO;
import com.spring.quiztime.entities.Question;
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


    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SubjectResponseDTO> getAllService() {
        return null;
    }

    @Override
    public Optional<SubjectResponseDTO> saveService(SubjectDTO subjectDTO) {

        Subject subject = modelMapper.map(subjectDTO,Subject.class);
        System.out.println(subject);

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

        if(subjectRepository.findById(Id).isPresent()){
            subjectRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<SubjectResponseDTO> updateService(SubjectDTO subjectDTO, Long Id) {
        if (subjectRepository.findById(Id).isPresent()){
            Subject subject = modelMapper.map(subjectDTO,Subject.class);
            System.out.println(subject);

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
            SubjectResponseDTO tmp = modelMapper.map(subject, SubjectResponseDTO.class);
            tmp.setQuestions(tmp.getQuestions());
            return Optional.of(tmp);
        }

        return  Optional.empty();
    }
}
