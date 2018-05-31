package me.annaisakova.mappers.mappersConfigs.orikaMapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.mappersConfigs.ConverterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarCustomMapper extends CustomMapper<Car, CarDto> {

    private ConverterHelper helper;

    @Autowired
    public CarCustomMapper(ConverterHelper helper) {
        this.helper = helper;
    }

    @Override
    public void mapAtoB(Car a, CarDto b, MappingContext context) {
        b.setName(a.getName());
        b.setEngineId(a.getEngine().getId());
        b.setWheelIds(helper.getWheelIds(a.getWheels()));
    }

    @Override
    public void mapBtoA(CarDto a, Car b, MappingContext context) {
        b.setName(a.getName());
        b.setWheels(helper.findWheels(a.getWheelIds()));
        b.setEngine(helper.findEngine(a.getEngineId()));
    }
}
