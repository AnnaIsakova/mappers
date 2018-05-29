package me.annaisakova.mappers.mappersConfigs;

import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;

public interface DtoConverter {

    Car fromDto(CarDto carDto);

    CarDto toDto(Car car);
}
