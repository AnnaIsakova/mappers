package me.annaisakova.mappers.mappersConfigs;

import me.annaisakova.mappers.aspects.TrackTime;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("modelMapper")
public class ModelMapperDtoConverterImpl implements DtoConverter {

    @Autowired
    private ModelMapper mapper;

    @TrackTime
    public Car fromDto(CarDto carDto){
        return mapper.map(carDto, Car.class);
    }

    @TrackTime
    public CarDto toDto(Car car){
        return mapper.map(car, CarDto.class);
    }
}
