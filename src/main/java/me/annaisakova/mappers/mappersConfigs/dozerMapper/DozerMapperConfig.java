package me.annaisakova.mappers.mappersConfigs.dozerMapper;


import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerMapperConfig {

    @Autowired
    DozerMapperCustomConverter customConverter;

    @Bean
    public DozerBeanMapper dozerMapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList();
        myMappingFiles.add("dozer-custom-converter.xml");
        mapper.setMappingFiles(myMappingFiles);
        return new DozerBeanMapper();
    }
}
