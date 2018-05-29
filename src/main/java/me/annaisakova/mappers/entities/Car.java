package me.annaisakova.mappers.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "car")
    private Engine engine;

    @OneToMany(mappedBy = "car", cascade= CascadeType.ALL)
    private List<Wheel> wheels;
}
