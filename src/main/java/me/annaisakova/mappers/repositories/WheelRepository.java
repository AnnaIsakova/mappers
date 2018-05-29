package me.annaisakova.mappers.repositories;

import me.annaisakova.mappers.entities.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WheelRepository extends JpaRepository<Wheel, Integer> {
}
