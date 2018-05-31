package me.annaisakova.mappers.mappersConfigs.mapStruct;


import me.annaisakova.mappers.aspects.TrackTimeFromDto;
import me.annaisakova.mappers.aspects.TrackTimeToDto;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mapStruct")
public class MapStructDtoConverter implements DtoConverter{

    @Autowired
    CarMapper carMapper;

    @TrackTimeFromDto
    @Override
    public Car fromDto(CarDto carDto) {
        return carMapper.fromDto(carDto);
    }

    @TrackTimeToDto
    @Override
    public CarDto toDto(Car car) {
        return carMapper.toDto(car);
    }
}
