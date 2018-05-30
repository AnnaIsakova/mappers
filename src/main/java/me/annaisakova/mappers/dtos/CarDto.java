package me.annaisakova.mappers.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CarDto {

    private String name;
    private Integer engineId;
    private List<Integer> wheelIds;
}
