package me.annaisakova.mappers.controllers;


import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/batch")
    @PostMapping
    public ResponseEntity<List<CarDto>> saveCars(@RequestBody List<CarDto> carDtos){
        List<CarDto> response = new ArrayList<>();
        for (CarDto dto:carDtos) {
            response.add(carService.saveCar(dto));
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
