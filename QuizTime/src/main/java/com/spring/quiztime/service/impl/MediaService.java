package com.spring.quiztime.service.impl;

import com.spring.quiztime.dto.Media.MediaDTO;
import com.spring.quiztime.entities.Media;
import com.spring.quiztime.repository.MediaRepository;
import com.spring.quiztime.service.interfaces.IMediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService implements IMediaService {


    private final ModelMapper modelMapper;


    private final MediaRepository mediaRepository;


    public MediaService(ModelMapper modelMapper,
                        MediaRepository mediaRepository){
        this.mediaRepository=mediaRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<MediaDTO> getAllService() {
        return Arrays.asList(modelMapper.map(mediaRepository.findAll(),MediaDTO[].class));
    }

    @Override
    public Optional<MediaDTO> saveService(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO,Media.class);
        media = mediaRepository.save(media);

        return Optional.ofNullable(modelMapper.map(media,MediaDTO.class));
    }

    @Override
    public boolean deleteService(Long Id) {
        if(mediaRepository.existsById(Id)){
            mediaRepository.deleteById(Id);
            return  true;
        }
        return false;
    }

    @Override
    public Optional<MediaDTO> updateService(MediaDTO mediaDTO, Long Id) {
        if (mediaRepository.existsById(Id)){
            Media media = modelMapper.map(mediaDTO,Media.class);
            media = mediaRepository.save(media);

            return Optional.ofNullable(modelMapper.map(media,MediaDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<MediaDTO> findByIdService(Long Id) {
        Optional<Media> mediaDTOOptional = mediaRepository.findById(Id);
        return mediaDTOOptional
                .map(media -> modelMapper.map(media,MediaDTO.class));
    }
}
