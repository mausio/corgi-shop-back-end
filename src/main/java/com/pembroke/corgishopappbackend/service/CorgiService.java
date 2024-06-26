package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.CorgiRepository;
import com.pembroke.corgishopappbackend.dto.CorgiDTO;
import com.pembroke.corgishopappbackend.entity.Corgi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorgiService {

    private final CorgiRepository corgiRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CorgiService(CorgiRepository corgiRepository, ModelMapper modelMapper) {
        this.corgiRepository = corgiRepository;
        this.modelMapper = modelMapper;
    }

    public List<CorgiDTO> findAll() {
        return corgiRepository.findAll().stream()
                .map(corgi -> modelMapper.map(corgi, CorgiDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public void save(Corgi corgi) {
        modelMapper.map(corgiRepository.save(corgi), CorgiDTO.class);
    } // TODO: Delete this function

    public Corgi findCorgiByUuid(String uuid) {
        return corgiRepository.findCorgiByUuid(uuid);
    }

}
