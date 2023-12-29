package com.spring.quiztime.service.impl;



import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Question.QuestionResponseDTO;
import com.spring.quiztime.entities.Media;
import com.spring.quiztime.entities.Question;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.repository.MediaRepository;
import com.spring.quiztime.repository.QuestionRepository;
import com.spring.quiztime.repository.SubjectRepository;
import com.spring.quiztime.service.interfaces.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {


    private final ModelMapper modelMapper;

    private final QuestionRepository questionRepository;

    private final LevelRepository levelRepository;

    private final SubjectRepository subjectRepository;

    private final MediaRepository mediaRepository;


    public QuestionService(ModelMapper modelMapper,
                           QuestionRepository questionRepository,
                           LevelRepository levelRepository,
                           SubjectRepository subjectRepository,
                           MediaRepository mediaRepository){
        this.questionRepository =questionRepository;
        this.subjectRepository= subjectRepository;
        this.mediaRepository=mediaRepository;
        this.levelRepository=levelRepository;
        this.modelMapper=modelMapper;

    }


    @Override
    public List<QuestionResponseDTO> getAllService() {

        return Arrays.asList(modelMapper.map(questionRepository.findAll(),QuestionResponseDTO[].class));
    }

    @Override
    public Page<QuestionResponseDTO> getAllServicePagination(Pageable pageable) {
        Page<Question> questionPage = this.questionRepository.findAll(pageable);

        return questionPage.map(question -> modelMapper.map(question,QuestionResponseDTO.class));
    }

    @Override
    public Optional<QuestionResponseDTO> saveService(QuestionDTO questionDTO) {
        int numberAnswers = questionDTO.getNumberAnswers();
        int trueAnswers = questionDTO.getNumberCorrectAnswers();
        int falseAnswers = questionDTO.getNumberFalseAnswers();

        if (numberAnswers == trueAnswers + falseAnswers) {




            Question question1 = modelMapper.map(questionDTO, Question.class);


            if (questionDTO.getSubject_id() != null) {
                question1.setSubject(
                        subjectRepository.findById(questionDTO.getSubject_id()).get()
                );
            }

            if (questionDTO.getLevel_id() != null) {
                question1.setLevel(
                        levelRepository.findById(questionDTO.getLevel_id()).get()
                );
            }

            if(questionDTO.getMedias().size() > 0){
                List<Media> medias = Arrays.asList(modelMapper.map(questionDTO.getMedias(), Media[].class));
                for(int i=0;i<medias.size();i++){
                    Media media = medias.get(i);
                    media.setQuestion(question1);
                    medias.set(i, media);
                }
                question1.setMedias(medias);
            }

            question1 = questionRepository.save(question1);
            System.out.println(question1.toString());
            return Optional.of(modelMapper.map(question1, QuestionResponseDTO.class));
        }
        return Optional.empty();
    }




    @Override
    public boolean deleteService(Long Id) {
        if(questionRepository.existsById(Id)){
            levelRepository.deleteById(Id);
        }
        return false;
    }

    @Override
    public Optional<QuestionResponseDTO> updateService(QuestionDTO questionDTO, Long Id) {

         if (levelRepository.existsById(Id)){
             int numberAnswers = questionDTO.getNumberAnswers();
             int trueAnswers =questionDTO.getNumberCorrectAnswers();
             int falseAnswers = questionDTO.getNumberFalseAnswers();

             if(numberAnswers == trueAnswers + falseAnswers){


                 Question question1 = modelMapper.map(questionDTO,Question.class);


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
