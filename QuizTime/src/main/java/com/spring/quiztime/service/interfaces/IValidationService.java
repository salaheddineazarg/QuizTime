package com.spring.quiztime.service.interfaces;

import com.spring.quiztime.dto.Validation.ValidationDTO;
import com.spring.quiztime.dto.Validation.ValidationResponseDTO;

import java.util.List;

public interface IValidationService extends IData<ValidationResponseDTO,ValidationDTO,Long> {
    List<ValidationResponseDTO> saveAllService(List<ValidationDTO> validationDTOList);
}
