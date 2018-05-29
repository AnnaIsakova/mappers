package me.annaisakova.mappers.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarDto {

    private String name;
    private Integer engineId;
    private List<Integer> wheelIds;
}
