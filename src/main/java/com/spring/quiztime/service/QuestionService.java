package com.spring.quiztime.service;


import com.spring.quiztime.dto.QuestionDTO;
import com.spring.quiztime.dto.QuestionResponseDTO;
import com.spring.quiztime.entities.Question;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.repository.QuestionRepository;
import com.spring.quiztime.repository.SubjectRepository;
import com.spring.quiztime.service.interfaces.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private SubjectRepository subjectRepository;




    @Override
    public List<QuestionResponseDTO> getAllService() {

        return Arrays.asList(modelMapper.map(questionRepository.findAll(),QuestionResponseDTO[].class));
    }

    @Override
    public Optional<QuestionResponseDTO> saveService(QuestionDTO questionDTO){
        int numberAnswers = questionDTO.getNumberAnswers();
        int trueAnswers =questionDTO.getNumberCorrectAnswers();
        int falseAnswers = questionDTO.getNumberFalseAnswers();

        if(numberAnswers == trueAnswers + falseAnswers){

            Question question1 = modelMapper.map(questionDTO,Question.class);

            System.out.println(question1);
            if (questionDTO.getSubject_id() != null){
                question1.setSubject(
                        subjectRepository.findById(questionDTO.getSubject_id()).get()
                );
            }

           if(questionDTO.getLevel_id() != null){
               question1.setLevel(
                       levelRepository.findById(questionDTO.getLevel_id()).get()
               );
           }
            question1 = questionRepository.save(question1);

            return Optional.of(modelMapper.map(question1, QuestionResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long Id) {
        if(questionRepository.findById(Id).isPresent()){
            levelRepository.deleteById(Id);
        }
        return false;
    }

    @Override
    public Optional<QuestionResponseDTO> updateService(QuestionDTO questionDTO, Long Id) {

         if (levelRepository.findById(Id).isPresent()){
             int numberAnswers = questionDTO.getNumberAnswers();
             int trueAnswers =questionDTO.getNumberCorrectAnswers();
             int falseAnswers = questionDTO.getNumberFalseAnswers();

             if(numberAnswers == trueAnswers + falseAnswers){

                 Question question1 = modelMapper.map(questionDTO,Question.class);

                 System.out.println(question1);
                 if (questionDTO.getSubject_id() != null){
                     question1.setSubject(
                             subjectRepository.findById(questionDTO.getSubject_id()).get()
                     );
                 }

                 if(questionDTO.getLevel_id() != null){
                     question1.setLevel(
                             levelRepository.findById(questionDTO.getLevel_id()).get()
                     );
                 }
                 question1.setId(Id);
                 question1 = questionRepository.save(question1);

                 return Optional.of(modelMapper.map(question1, QuestionResponseDTO.class));
             }
         }
        return Optional.empty();
    }

    @Override
    public Optional<QuestionResponseDTO> findByIdService(Long Id) {

        return Optional.ofNullable(modelMapper.map(questionRepository.findById(Id),QuestionResponseDTO.class));
    }





}
