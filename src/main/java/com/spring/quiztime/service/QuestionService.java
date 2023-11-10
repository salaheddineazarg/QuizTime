package com.spring.quiztime.service;


import com.spring.quiztime.entities.Question;
import com.spring.quiztime.repository.QuestionRepository;
import com.spring.quiztime.service.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
   private QuestionRepository questionRepository;



    @Override
    public List<Question> getAllService(){

        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> saveService(Question question){
        int numberAnswers = question.getNumberAnswers();
        int trueAnswers =question.getNumberCorrectAnswers();
        int falseAnswers = question.getNumberFalseAnswers();

        if(numberAnswers == trueAnswers + falseAnswers){
              return Optional.of(questionRepository.save(question));
          }
        return Optional.empty();
    }

    @Override
    public boolean deleteService(Long id){
        if(questionRepository.findById(id).isPresent()){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Optional<Question> updateService(Question question,Long id){
        if(questionRepository.findById(id).isPresent()){
            question.setId(id);
            return Optional.of(questionRepository.save(question));
        }
        return null;
    }
    @Override
    public Optional<Question> findByIdService(Long id){

        return questionRepository.findById(id);
    }

}
