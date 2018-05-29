package me.annaisakova.mappers.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Wheel {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
