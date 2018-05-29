package me.annaisakova.mappers.mappersConfigs;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.entities.Engine;
import me.annaisakova.mappers.entities.Wheel;
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

    private EngineRepository engineRepository;
    private WheelRepository wheelRepository;

    @Autowired
    public ModelMapperConfig(EngineRepository engineRepository, WheelRepository wheelRepository) {
        this.engineRepository = engineRepository;
        this.wheelRepository = wheelRepository;
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
            car.setEngine(findEngine(context.getSource().getEngineId()));
            car.setWheels(findWheels(context.getSource().getWheelIds()));
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
            carDto.setWheelIds(getWheelIds(context.getSource().getWheels()));
            return carDto;
        };
        modelMapper.createTypeMap(Car.class, CarDto.class)
                .setConverter(toDtoConverter);
    }

    private Engine findEngine(Integer id){
        return engineRepository.getOne(id);
    }

    private List<Wheel> findWheels(List<Integer> ids){
        List<Wheel> wheels = new ArrayList<>();
        for (Integer id:ids) {
            wheels.add(wheelRepository.getOne(id));
        }
        return wheels;
    }

    private List<Integer> getWheelIds(List<Wheel> wheels){
        List<Integer> wheelIds = new ArrayList<>();
        for (Wheel wheel:wheels) {
            wheelIds.add(wheel.getId());
        }
        return wheelIds;
    }
}
