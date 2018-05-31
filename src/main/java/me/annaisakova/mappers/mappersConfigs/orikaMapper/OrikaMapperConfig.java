package me.annaisakova.mappers.mappersConfigs.orikaMapper;


import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaMapperConfig {

    private CustomMapper customMapper;

    @Autowired
    public OrikaMapperConfig(CustomMapper customMapper) {
        this.customMapper = customMapper;
    }

    @Bean
    public MapperFacade mapperFacade(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Car.class, CarDto.class)
                .customize(customMapper).register();
        return mapperFactory.getMapperFacade();
    }
}
