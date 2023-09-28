package com.apidelivery.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean //Já fica pronto para ser usado e é gerenciado automaticamente pelo spring;
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
