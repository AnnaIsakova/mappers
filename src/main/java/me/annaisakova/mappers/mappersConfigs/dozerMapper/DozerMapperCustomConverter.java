package me.annaisakova.mappers.mappersConfigs.dozerMapper;

import lombok.NoArgsConstructor;
import me.annaisakova.mappers.dtos.CarDto;
import me.annaisakova.mappers.entities.Car;
import me.annaisakova.mappers.entities.Engine;
import me.annaisakova.mappers.mappersConfigs.ConverterHelper;
import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component
public class DozerMapperCustomConverter implements CustomConverter {

    private ConverterHelper helper;

    public DozerMapperCustomConverter() {
    }

    @Autowired
    public DozerMapperCustomConverter(ConverterHelper helper) {
        this.helper = helper;
    }

    @Override
    public Object convert(Object dest, Object source, Class<?> destinationClass, Class<?> sourceClass) {
        if (source == null)
            return null;

        System.out.println("+++++++++++++++++++++++++++++++CONVERTER+++++++++++++++++++++++");
        if (source instanceof CarDto) {
            CarDto carDto = (CarDto) source;
            Car car = new Car();
            car.setEngine(helper.findEngine(carDto.getEngineId()));
            car.setWheels(helper.findWheels(carDto.getWheelIds()));
            return car;

        } else if (source instanceof Car) {
            Car car = (Car) source;
            CarDto carDto = new CarDto();
            carDto.setEngineId(car.getEngine().getId());
            carDto.setWheelIds(helper.getWheelIds(car.getWheels()));
            return carDto;
        }

        return null;
    }

}