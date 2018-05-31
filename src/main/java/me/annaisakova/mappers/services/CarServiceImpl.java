package me.annaisakova.mappers.services;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.DtoConverter;
import me.annaisakova.mappers.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private DtoConverter dtoConverter;

    //@Qualifier("modelMapper")
    //@Qualifier("dozerMapper")
    //@Qualifier("mapStruct")
    @Autowired
    public CarServiceImpl(CarRepository carRepository, @Qualifier("mapStruct") DtoConverter dtoConverter) {
        this.carRepository = carRepository;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        Car car = carRepository.saveAndFlush(dtoConverter.fromDto(carDto));
        return dtoConverter.toDto(car);
    }
}
