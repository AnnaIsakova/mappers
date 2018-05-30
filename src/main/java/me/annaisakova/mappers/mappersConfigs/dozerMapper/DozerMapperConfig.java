package me.annaisakova.mappers.mappersConfigs.dozerMapper;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;

@Configuration
public class DozerMapperConfig {

    @Autowired
    DozerMapperCustomConverter converter;

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(CarDto.class, Car.class)
                        .fields("name", "name")
                        .fields("engineId", "engine", customConverter(DozerMapperCustomConverter.class))
                        .fields("wheelIds", "wheels", customConverter(DozerMapperCustomConverter.class));
            }
        };
    }

    @Bean
    public DozerBeanMapper dozerMapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozer-custom-converter.xml");
        mapper.setMappingFiles(myMappingFiles);
        return mapper;
    }
}
