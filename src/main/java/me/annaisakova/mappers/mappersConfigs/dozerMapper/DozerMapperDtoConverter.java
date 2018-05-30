package me.annaisakova.mappers.mappersConfigs.dozerMapper;

import lombok.NoArgsConstructor;
import me.annaisakova.mappers.aspects.TrackTime;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.DtoConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("dozerMapper")
@NoArgsConstructor
public class DozerMapperDtoConverter implements DtoConverter {

    private DozerBeanMapper mapper;

    @Autowired
    public DozerMapperDtoConverter(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }

    @TrackTime
    @Override
    public Car fromDto(CarDto carDto) {
        return mapper.map(carDto, Car.class);
    }

    @TrackTime
    @Override
    public CarDto toDto(Car car) {
        return mapper.map(car, CarDto.class);
    }
}
