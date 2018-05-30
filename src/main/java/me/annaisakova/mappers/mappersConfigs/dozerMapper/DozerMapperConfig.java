package me.annaisakova.mappers.mappersConfigs.dozerMapper;


import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DozerMapperConfig {

    @Autowired
    DozerMapperCustomConverter customConverter;

    @Bean
    public DozerBeanMapper dozerMapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<CustomConverter> converters = new ArrayList<>();
        converters.add(customConverter);
        mapper.setCustomConverters(converters);
        return new DozerBeanMapper();
    }
}
