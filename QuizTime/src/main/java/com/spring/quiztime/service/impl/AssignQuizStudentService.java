package com.spring.quiztime.service.impl;


import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentDTO;
import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentResponseDTO;
import com.spring.quiztime.entities.AssignQuizStudent;
import com.spring.quiztime.repository.AssignQuizStudentRepository;
import com.spring.quiztime.repository.QuizRepository;
import com.spring.quiztime.repository.StudentRepository;
import com.spring.quiztime.service.interfaces.IAssignQuizStudent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignQuizStudentService implements IAssignQuizStudent {



     private final ModelMapper modelMapper;


     private final AssignQuizStudentRepository assignQuizStudentRepository;


     private final StudentRepository studentRepository;


     private final QuizRepository quizRepository;


     public AssignQuizStudentService(ModelMapper modelMapper,
                                      AssignQuizStudentRepository assignQuizStudentRepository,
                                      StudentRepository studentRepository,
                                      QuizRepository quizRepository){
         this.modelMapper=modelMapper;
         this.assignQuizStudentRepository=assignQuizStudentRepository;
         this.quizRepository=quizRepository;
         this.studentRepository=studentRepository;

     }

    @Override
    public List<AssignQuizStudentResponseDTO> getAllService() {
         List<AssignQuizStudent> assignQuizStudents = assignQuizStudentRepository.findAll();
        return Arrays.asList(modelMapper.map(assignQuizStudents,AssignQuizStudentResponseDTO[].class));
    }

    @Override
    public Optional<AssignQuizStudentResponseDTO> saveService(AssignQuizStudentDTO assignQuizStudentDTO) {
        AssignQuizStudent assignQuizStudent = modelMapper.map(assignQuizStudentDTO,AssignQuizStudent.class) ;

        if (assignQuizStudentDTO.getQuiz_id() != null){
            assignQuizStudent.setQuiz(
                    quizRepository.findById(assignQuizStudentDTO.getQuiz_id()).get()
            );
        }

        if (assignQuizStudentDTO.getStudent_id() != null){
            assignQuizStudent.setStudent(
                    studentRepository.findById(assignQuizStudentDTO.getStudent_id()).get()
            );
        }

        assignQuizStudent = assignQuizStudentRepository.save(assignQuizStudent);

        return Optional.ofNullable(modelMapper.map(assignQuizStudent,AssignQuizStudentResponseDTO.class));
    }


    public List<AssignQuizStudentResponseDTO> saveAllService(List<AssignQuizStudentDTO> assignQuizStudentDTOList) {
        List<AssignQuizStudent> responseDTOList = new ArrayList<>();

        for (AssignQuizStudentDTO assignQuizStudentDTO : assignQuizStudentDTOList) {
            AssignQuizStudent assignQuizStudent = modelMapper.map(assignQuizStudentDTO, AssignQuizStudent.class);

            if (assignQuizStudentDTO.getQuiz_id() != null) {
                assignQuizStudent.setQuiz(
                        quizRepository.findById(assignQuizStudentDTO.getQuiz_id()).orElse(null)
                );
            }

            if (assignQuizStudentDTO.getStudent_id() != null) {
                assignQuizStudent.setStudent(
                        studentRepository.findById(assignQuizStudentDTO.getStudent_id()).orElse(null)
                );
            }

            responseDTOList.add(assignQuizStudent);
        }
        List<AssignQuizStudent> assignQuizStudentList = assignQuizStudentRepository.saveAll(responseDTOList);

        return assignQuizStudentList.stream()
                .map(assignQuizStudent -> modelMapper.map(assignQuizStudent,AssignQuizStudentResponseDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public boolean deleteService(Long Id) {
        if(assignQuizStudentRepository.existsById(Id)){
            assignQuizStudentRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<AssignQuizStudentResponseDTO> updateService(AssignQuizStudentDTO assignQuizStudentDTO, Long Id) {
        if (assignQuizStudentRepository.existsById(Id)){
            AssignQuizStudent assignQuizStudent = modelMapper.map(assignQuizStudentDTO,AssignQuizStudent.class) ;
            assignQuizStudent.setId(Id);
            if (assignQuizStudentDTO.getQuiz_id() != null){
                assignQuizStudent.setQuiz(
                        quizRepository.findById(assignQuizStudentDTO.getQuiz_id()).get()
                );
            }

            if (assignQuizStudentDTO.getStudent_id() != null){
                assignQuizStudent.setStudent(
                        studentRepository.findById(assignQuizStudentDTO.getStudent_id()).get()
                );
            }

            assignQuizStudent = assignQuizStudentRepository.save(assignQuizStudent);

            return Optional.ofNullable(modelMapper.map(assignQuizStudent,AssignQuizStudentResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AssignQuizStudentResponseDTO> findByIdService(Long Id) {
        Optional<AssignQuizStudent> assignQuizStudent = assignQuizStudentRepository.findById(Id);

        return assignQuizStudent.map(assignQS -> modelMapper.map(assignQS,AssignQuizStudentResponseDTO.class));
    }
    public List<AssignQuizStudentResponseDTO> findByQuizId(Long Id) {
        List<AssignQuizStudent> assignQuizStudentList = assignQuizStudentRepository.findByQuizId(Id);

        return assignQuizStudentList.stream().map(assignQuizStudent -> modelMapper.map(assignQuizStudent,AssignQuizStudentResponseDTO.class))
                .collect(Collectors.toList());
    }
}
