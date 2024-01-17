package com.spring.quiztime.service.impl;


import com.spring.quiztime.dto.Answer.AnswerDTO;
import com.spring.quiztime.dto.Answer.AnswerResponseDTO;
import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentDTO;
import com.spring.quiztime.dto.Validation.ValidationDTO;
import com.spring.quiztime.entities.Answer;
import com.spring.quiztime.repository.AnswerRepository;
import com.spring.quiztime.repository.AssignQuizStudentRepository;
import com.spring.quiztime.repository.ValidationRepository;
import com.spring.quiztime.service.interfaces.IAnswerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService  implements IAnswerService {



    private final AnswerRepository answerRepository;

    private final AssignQuizStudentRepository assignQuizStudentRepository;

    private final ValidationRepository validationRepository;

    private final ModelMapper modelMapper;


    public AnswerService(AnswerRepository answerRepository,
                         AssignQuizStudentRepository  assignQuizStudentRepository,
                          ValidationRepository validationRepository,
                         ModelMapper modelMapper
            ){
        this.answerRepository=answerRepository;
        this.assignQuizStudentRepository =assignQuizStudentRepository;
        this.validationRepository = validationRepository;
        this.modelMapper=modelMapper;
    }




    @Override
    public List<AnswerResponseDTO> getAllService() {
        return Arrays.asList(modelMapper.map(answerRepository.findAll(),AnswerResponseDTO[].class));
    }

    @Override
    public Optional<AnswerResponseDTO> saveService(AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO,Answer.class);

        if (answerDTO.getAssignQuizStudent_id() != null){

            answer.setAssignQuizStudent(
                    assignQuizStudentRepository.findById(answerDTO.getAssignQuizStudent_id()).get()
            );
        }
        if (answerDTO.getValidation_id()!=null){
            answer.setValidation(
                    validationRepository.findById(answerDTO.getValidation_id()).get()
            );
        }

        answer = answerRepository.save(answer);
        AnswerResponseDTO answerResponseDTO = modelMapper.map(answer,AnswerResponseDTO.class);

        AssignQuizStudentDTO assignQuizStudent = answerResponseDTO.getAssignQuizStudent();
        assignQuizStudent.setQuiz_id(answer.getAssignQuizStudent().getQuiz().getId());
        assignQuizStudent.setStudent_id(answer.getAssignQuizStudent().getStudent().getId());
        answerResponseDTO.setAssignQuizStudent(assignQuizStudent);

        ValidationDTO validationDTO =answerResponseDTO.getValidation();
        validationDTO.setQuestion_id(answer.getValidation().getQuestion().getId());
        validationDTO.setResponse_id(answer.getValidation().getResponse().getId());

         answerResponseDTO.setValidation(validationDTO);

        return Optional.ofNullable(answerResponseDTO);
    }

    @Override
    public boolean deleteService(Long Id) {

        if (answerRepository.existsById(Id)){

            answerRepository.deleteById(Id);
        return true;
        }
        return false;
    }

    @Override
    public Optional<AnswerResponseDTO> updateService(AnswerDTO answerDTO, Long Id) {
        if (answerRepository.existsById(Id)){
            Answer answer = modelMapper.map(answerDTO,Answer.class);
            if (answerDTO.getAssignQuizStudent_id() != null){

                answer.setAssignQuizStudent(
                        assignQuizStudentRepository.findById(answerDTO.getAssignQuizStudent_id()).get()
                );
            }
            if (answerDTO.getValidation_id()!=null){
                answer.setValidation(
                        validationRepository.findById(answerDTO.getValidation_id()).get()
                );
            }
            answer = answerRepository.save(answer);

            return Optional.of(modelMapper.map(answer,AnswerResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AnswerResponseDTO> findByIdService(Long Id) {
        Optional<Answer> answerOptional = answerRepository.findById(Id);
        return answerOptional
                .map(answer -> modelMapper.map(answer,AnswerResponseDTO.class));
    }
}
