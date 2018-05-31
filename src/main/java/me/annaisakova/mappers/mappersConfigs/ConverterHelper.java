package me.annaisakova.mappers.mappersConfigs;


import me.annaisakova.mappers.entities.Engine;
import me.annaisakova.mappers.entities.Wheel;
import me.annaisakova.mappers.repositories.EngineRepository;
import me.annaisakova.mappers.repositories.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterHelper {

    private EngineRepository engineRepository;
    private WheelRepository wheelRepository;

//    @Autowired
//    public ConverterHelper(EngineRepository engineRepository, WheelRepository wheelRepository) {
//        this.engineRepository = engineRepository;
//        this.wheelRepository = wheelRepository;
//    }


    @Autowired
    public void setEngineRepository(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Autowired
    public void setWheelRepository(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }

    public Engine findEngine(Integer id){
        return engineRepository.getOne(id);
    }

    public List<Wheel> findWheels(List<Integer> ids){
        List<Wheel> wheels = new ArrayList<>();
        for (Integer id:ids) {
            wheels.add(wheelRepository.getOne(id));
        }
        return wheels;
    }

    public List<Integer> getWheelIds(List<Wheel> wheels){
        List<Integer> wheelIds = new ArrayList<>();
        for (Wheel wheel:wheels) {
            wheelIds.add(wheel.getId());
        }
        return wheelIds;
    }
}
