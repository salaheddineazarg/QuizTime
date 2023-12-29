package com.spring.quiztime.service.interfaces;

import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentDTO;
import com.spring.quiztime.dto.AssignQuizStudent.AssignQuizStudentResponseDTO;

import java.util.List;

public interface IAssignQuizStudent extends IData<AssignQuizStudentResponseDTO,AssignQuizStudentDTO,Long>{
    List<AssignQuizStudentResponseDTO> saveAllService(List<AssignQuizStudentDTO> assignQuizStudentDTOList);
}
