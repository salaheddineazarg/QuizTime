package com.spring.quiztime.service;

import com.spring.quiztime.dto.QuizQuestion.QuizQuestionDTO;
import com.spring.quiztime.dto.QuizQuestion.QuizQuestionResponseDTO;
import com.spring.quiztime.dto.Validation.ValidationResponseDTO;
import com.spring.quiztime.entities.QuizQuestion;
import com.spring.quiztime.entities.Validation;
import com.spring.quiztime.exception.ResourceNotFoundException;
import com.spring.quiztime.repository.QuestionRepository;
import com.spring.quiztime.repository.QuizQuestionRepository;
import com.spring.quiztime.repository.QuizRepository;
import com.spring.quiztime.service.interfaces.IQuizQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class QuizQuestionService implements IQuizQuestionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<QuizQuestionResponseDTO> getAllService() {
        return null;
    }


    @Override
    public List<QuizQuestionResponseDTO> saveAllService(List<QuizQuestionDTO> quizQuestionDTOList) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        for ( QuizQuestionDTO quizQuestionDTO : quizQuestionDTOList){
           QuizQuestion  quizQuestion = modelMapper.map(quizQuestionDTO,QuizQuestion.class);


           if (quizQuestionDTO.getQuestion_id()!=null){
               quizQuestion.setQuestion(
               questionRepository.findById(quizQuestionDTO.getQuestion_id()).get()
               );

           }

           if (quizQuestionDTO.getQuiz_id()!=null){
               quizQuestion.setQuiz(
                       quizRepository.findById(quizQuestionDTO.getQuiz_id()).get()
               );
           }
           quizQuestions.add(quizQuestion);

        }

        List<QuizQuestion> savedValidations = quizQuestionRepository.saveAll(quizQuestions);

        return savedValidations.stream()
                .map(quizQuestion -> modelMapper.map(quizQuestion, QuizQuestionResponseDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<QuizQuestionResponseDTO> saveService(QuizQuestionDTO quizQuestionDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long Id) {
        if(quizQuestionRepository.existsById(Id)){
            quizQuestionRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<QuizQuestionResponseDTO> updateService(QuizQuestionDTO quizQuestionDTO, Long Id) {
        if (quizQuestionRepository.existsById(Id)){
            QuizQuestion quizQuestion = modelMapper.map(quizQuestionDTO,QuizQuestion.class);
            quizQuestion.setId(Id);
            quizQuestion = quizQuestionRepository.save(quizQuestion);

            return Optional.of(modelMapper.map(quizQuestion,QuizQuestionResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<QuizQuestionResponseDTO> findByIdService(Long Id) {
        Optional<QuizQuestion> quizQuestionOptional = quizQuestionRepository.findById(Id);
        return quizQuestionOptional
                .map(quizQuestion -> modelMapper.map(quizQuestion,QuizQuestionResponseDTO.class));
    }

    public List<QuizQuestionResponseDTO> findBYQuizId(Long id){
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findByQuizId(id);
        return Arrays.asList(modelMapper.map(quizQuestions,QuizQuestionResponseDTO[].class));
    }
}


