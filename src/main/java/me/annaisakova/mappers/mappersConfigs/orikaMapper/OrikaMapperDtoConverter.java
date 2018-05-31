package me.annaisakova.mappers.mappersConfigs.orikaMapper;


import ma.glasnost.orika.MapperFacade;
import me.annaisakova.mappers.aspects.TrackTimeFromDto;
import me.annaisakova.mappers.aspects.TrackTimeToDto;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("orikaMapper")
public class OrikaMapperDtoConverter implements DtoConverter{

    @Autowired
    MapperFacade mapperFacade;

    @TrackTimeFromDto
    @Override
    public Car fromDto(CarDto carDto) {
        return mapperFacade.map(carDto, Car.class);
    }

    @TrackTimeToDto
    @Override
    public CarDto toDto(Car car) {
        return mapperFacade.map(car, CarDto.class);
    }
}
