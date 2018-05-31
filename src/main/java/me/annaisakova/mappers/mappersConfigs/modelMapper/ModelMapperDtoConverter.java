package me.annaisakova.mappers.mappersConfigs.modelMapper;

import me.annaisakova.mappers.aspects.TrackTimeFromDto;
import me.annaisakova.mappers.aspects.TrackTimeToDto;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.DtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("modelMapper")
public class ModelMapperDtoConverter implements DtoConverter {

    @Autowired
    private ModelMapper mapper;

    @TrackTimeFromDto
    public Car fromDto(CarDto carDto){
        return mapper.map(carDto, Car.class);
    }

    @TrackTimeToDto
    public CarDto toDto(Car car){
        return mapper.map(car, CarDto.class);
    }
}
