package me.annaisakova.mappers.mappersConfigs.mapStruct;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.ConverterHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CarMapper {

    @Autowired
    private ConverterHelper helper;

    public CarMapper() { }

    CarDto toDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setName(car.getName());
        carDto.setEngineId(car.getEngine().getId());
        carDto.setWheelIds(helper.getWheelIds(car.getWheels()));
        return carDto;
    }

    Car fromDto(CarDto carDto){
        System.out.println("CAR DTO: " + carDto);
        Car car = new Car();
        car.setName(carDto.getName());
        car.setEngine(helper.findEngine(carDto.getEngineId()));
        car.setWheels(helper.findWheels(carDto.getWheelIds()));
        return car;
    }
}
