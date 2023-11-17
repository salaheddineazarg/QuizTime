package com.spring.quiztime.service;


import com.spring.quiztime.dto.StudentDTO;
import com.spring.quiztime.entities.Student;
import com.spring.quiztime.repository.StudentRepository;
import com.spring.quiztime.service.interfaces.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService  implements IStudentService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllService() {

        return Arrays.asList(modelMapper.map(studentRepository.findAll(),StudentDTO[].class));
    }

    @Override
    public Optional<StudentDTO> saveService(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO,Student.class);
        student = studentRepository.save(student);

        return Optional.ofNullable(modelMapper.map(student,StudentDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {
        if (studentRepository.existsById(Id)){
            studentRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<StudentDTO> updateService(StudentDTO studentDTO, Long Id) {
        if (studentRepository.existsById(Id)){
          Student student = modelMapper.map(studentDTO,Student.class);
          student.setId(Id);
          student = studentRepository.save(student);

          return Optional.of(modelMapper.map(student,StudentDTO.class));
    }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> findByIdService(Long Id) {
        Student student = studentRepository.findById(Id).get();
        if (student != null){
            return Optional.ofNullable(modelMapper.map(student,StudentDTO.class));
        }
        return Optional.empty();
    }
}
