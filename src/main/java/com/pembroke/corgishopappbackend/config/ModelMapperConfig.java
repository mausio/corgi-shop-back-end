package com.pembroke.corgishopappbackend.config;

import com.pembroke.corgishopappbackend.dto.CorgiDTO;
import com.pembroke.corgishopappbackend.entity.Corgi;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Corgi, CorgiDTO> corgiTypeMap = modelMapper.createTypeMap(Corgi.class, CorgiDTO.class);

        return modelMapper;
    }
}