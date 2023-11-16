package com.spring.quiztime.service;

import com.spring.quiztime.dto.QuizDTO;
import com.spring.quiztime.entities.Quiz;
import com.spring.quiztime.repository.QuizRepository;
import com.spring.quiztime.service.interfaces.IQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<QuizDTO> getAllService() {
       List<Quiz> quizzes = quizRepository.findAll();
        return Arrays.asList(modelMapper.map(quizzes,QuizDTO[].class));
    }

    @Override
    public Optional<QuizDTO> saveService(QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO,Quiz.class);
        quiz = quizRepository.save(quiz);
        return Optional.of(modelMapper.map(quiz,QuizDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {

        if (quizRepository.existsById(Id)){
            quizRepository.deleteById(Id);
            return true;
         }
        return false;
    }

    @Override
    public Optional<QuizDTO> updateService(QuizDTO quizDTO, Long Id) {
        if (quizRepository.existsById(Id)){
            Quiz quiz = modelMapper.map(quizDTO,Quiz.class);
            quiz.setId(Id);
            quiz = quizRepository.save(quiz);
            return Optional.of(modelMapper.map(quiz,QuizDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<QuizDTO> findByIdService(Long Id) {
       Quiz quiz = quizRepository.findById(Id).get();
        return Optional.ofNullable(modelMapper.map(quiz,QuizDTO.class));
    }
}
