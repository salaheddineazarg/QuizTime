package com.spring.quiztime.service;

import com.spring.quiztime.dto.Validation.ValidationDTO;
import com.spring.quiztime.dto.Validation.ValidationResponseDTO;
import com.spring.quiztime.entities.Validation;
import com.spring.quiztime.exception.ResourceNotFoundException;
import com.spring.quiztime.repository.QuestionRepository;
import com.spring.quiztime.repository.ResponseRepository;
import com.spring.quiztime.repository.ValidationRepository;
import com.spring.quiztime.service.interfaces.IValidationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ValidationService implements IValidationService {


    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ValidationResponseDTO> getAllService() {
        return Arrays.asList(modelMapper.map(validationRepository.findAll(),ValidationResponseDTO.class));
    }

    @Override
    public Optional<ValidationResponseDTO> saveService(ValidationDTO validationDTO) {
       return  null;
    }

    public List<ValidationResponseDTO> saveAllService(List<ValidationDTO> validationDTOList) {
        List<Validation> validations = new ArrayList<>();

        for (ValidationDTO validationDTO : validationDTOList) {
            Validation validation = modelMapper.map(validationDTO, Validation.class);

            if (validationDTO.getQuestion_id() != null) {
                validation.setQuestion(
                        questionRepository.findById(validationDTO.getQuestion_id()).orElseThrow(
                                () -> new ResourceNotFoundException("Question not found for ID: " + validationDTO.getQuestion_id())
                        )
                );
            }

            if (validationDTO.getResponse_id() != null) {
                validation.setResponse(
                        responseRepository.findById(validationDTO.getResponse_id()).orElseThrow(
                                () -> new ResourceNotFoundException("Response not found for ID: " + validationDTO.getResponse_id())
                        )
                );
            }
            validations.add(validation);
        }

        List<Validation> savedValidations = validationRepository.saveAll(validations);

        return savedValidations.stream()
                .map(validation -> modelMapper.map(validation, ValidationResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteService(Long Id) {
        if(validationRepository.existsById(Id)){
            validationRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<ValidationResponseDTO> updateService(ValidationDTO validationDTO, Long Id) {
        if (validationRepository.existsById(Id)){
            Validation validation = modelMapper.map(validationDTO,Validation.class);
            validation.setId(Id);
            validation = validationRepository.save(validation);

            return Optional.of(modelMapper.map(validation,ValidationResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ValidationResponseDTO> findByIdService(Long Id) {
        Optional<Validation>  validation = validationRepository.findById(Id);
        return validation
                .map(validation1 -> modelMapper.map(validation1, ValidationResponseDTO.class));
    }
}
