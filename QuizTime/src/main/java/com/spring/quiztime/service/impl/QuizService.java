package com.spring.quiztime.service.impl;

import com.spring.quiztime.dto.Quiz.QuizDTO;
import com.spring.quiztime.dto.Quiz.QuizResponseDTO;
import com.spring.quiztime.entities.Quiz;
import com.spring.quiztime.repository.QuizRepository;
import com.spring.quiztime.repository.TeacherRepository;
import com.spring.quiztime.service.interfaces.IQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService {


    private QuizRepository quizRepository;


    private TeacherRepository teacherRepository;

    private ModelMapper modelMapper;


    public QuizService(QuizRepository quizRepository,
                       TeacherRepository teacherRepository,
                       ModelMapper modelMapper){
        this.quizRepository = quizRepository;
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<QuizResponseDTO> getAllService() {
       List<Quiz> quizzes = quizRepository.findAll();
        return Arrays.asList(modelMapper.map(quizzes,QuizResponseDTO[].class));
    }

    @Override
    public Optional<QuizResponseDTO> saveService(QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO,Quiz.class);
        if(quizDTO.getTeacher_id() != null){
            quiz.setTeacher(
                    teacherRepository.findById(quizDTO.getTeacher_id()).get()
            );
        }

        quiz = quizRepository.save(quiz);
        return Optional.of(modelMapper.map(quiz,QuizResponseDTO.class));
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
    public Optional<QuizResponseDTO> updateService(QuizDTO quizDTO, Long Id) {
        if (quizRepository.existsById(Id)){
            Quiz quiz = modelMapper.map(quizDTO,Quiz.class);
            quiz.setId(Id);
            quiz = quizRepository.save(quiz);
            return Optional.of(modelMapper.map(quiz,QuizResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<QuizResponseDTO> findByIdService(Long Id) {
       Quiz quiz = quizRepository.findById(Id).get();
        return Optional.ofNullable(modelMapper.map(quiz,QuizResponseDTO.class));
    }
}
