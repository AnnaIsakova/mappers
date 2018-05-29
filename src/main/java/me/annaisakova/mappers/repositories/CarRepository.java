package me.annaisakova.mappers.repositories;

import me.annaisakova.mappers.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
