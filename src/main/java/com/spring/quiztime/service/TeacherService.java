package com.spring.quiztime.service;

import com.spring.quiztime.dto.TeacherDTO;
import com.spring.quiztime.entities.Teacher;
import com.spring.quiztime.repository.TeacherRepository;
import com.spring.quiztime.service.interfaces.ITeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TeacherRepository  teacherRepository;

    @Override
    public List<TeacherDTO> getAllService() {

        return Arrays.asList(modelMapper.map(teacherRepository.findAll(),TeacherDTO[].class));
    }

    @Override
    public Optional<TeacherDTO> saveService(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO,Teacher.class);
        teacher =  teacherRepository.save(teacher);
        return Optional.ofNullable(modelMapper.map(teacher,TeacherDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {
        if (teacherRepository.existsById(Id)){
            teacherRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<TeacherDTO> updateService(TeacherDTO teacherDTO, Long Id) {
        if (teacherRepository.existsById(Id)){
            Teacher teacher =   modelMapper.map(teacherDTO,Teacher.class);
            teacher.setId(Id);
            teacher = teacherRepository.save(teacher);
            return Optional.of(modelMapper.map(teacher,TeacherDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TeacherDTO> findByIdService(Long Id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(Id);
        return optionalTeacher.map(teacher -> modelMapper.map(teacher, TeacherDTO.class));
    }
}
