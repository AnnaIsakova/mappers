package me.annaisakova.mappers.services;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto saveCarDto(CarDto carDto) {
        return carDto;
    }
}
