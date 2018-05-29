package me.annaisakova.mappers.mappersConfigs;

import me.annaisakova.mappers.TrackTime;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoConverterImpl implements DtoConverter {

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
