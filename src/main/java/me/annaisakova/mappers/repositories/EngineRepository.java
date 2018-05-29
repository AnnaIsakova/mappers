package me.annaisakova.mappers.repositories;

import me.annaisakova.mappers.entities.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface EngineRepository extends JpaRepository<Engine, Integer> {
}
