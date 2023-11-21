package com.spring.quiztime.service.interfaces;

import com.spring.quiztime.dto.QuizQuestion.QuizQuestionDTO;
import com.spring.quiztime.dto.QuizQuestion.QuizQuestionResponseDTO;

import java.util.List;

public interface IQuizQuestionService extends IData<QuizQuestionResponseDTO, QuizQuestionDTO,Long> {


    List<QuizQuestionResponseDTO> saveAllService(List<QuizQuestionDTO> quizQuestionDTOList);
}
