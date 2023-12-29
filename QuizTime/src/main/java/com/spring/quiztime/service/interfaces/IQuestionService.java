package com.spring.quiztime.service.interfaces;

import com.spring.quiztime.dto.Question.QuestionDTO;
import com.spring.quiztime.dto.Question.QuestionResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IQuestionService extends IData<QuestionResponseDTO, QuestionDTO,Long> {
    Page<QuestionResponseDTO> getAllServicePagination(Pageable pageable);
}
