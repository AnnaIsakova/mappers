package me.annaisakova.mappers.mappersConfigs.modelMapper;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.entities.Engine;
import me.annaisakova.mappers.entities.Wheel;
import me.annaisakova.mappers.mappersConfigs.ConverterHelper;
import me.annaisakova.mappers.repositories.EngineRepository;
import me.annaisakova.mappers.repositories.WheelRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    private ConverterHelper helper;

    @Autowired
    public ModelMapperConfig(ConverterHelper helper) {
        this.helper = helper;
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        addFromDtoConverter(modelMapper);
        addToDtoConverter(modelMapper);
        return modelMapper;
    }

    private void addFromDtoConverter(ModelMapper modelMapper){
        Converter<CarDto, Car> fromDtoConverter = context -> {
            Car car = new Car();
            car.setName(context.getSource().getName());
            car.setEngine(helper.findEngine(context.getSource().getEngineId()));
            car.setWheels(helper.findWheels(context.getSource().getWheelIds()));
            return car;
        };
        modelMapper.createTypeMap(CarDto.class, Car.class)
                .setConverter(fromDtoConverter);
    }

    private void addToDtoConverter(ModelMapper modelMapper){
        Converter<Car, CarDto> toDtoConverter = context -> {
            CarDto carDto = new CarDto();
            carDto.setName(context.getSource().getName());
            carDto.setEngineId(context.getSource().getEngine().getId());
            carDto.setWheelIds(helper.getWheelIds(context.getSource().getWheels()));
            return carDto;
        };
        modelMapper.createTypeMap(Car.class, CarDto.class)
                .setConverter(toDtoConverter);
    }
}
