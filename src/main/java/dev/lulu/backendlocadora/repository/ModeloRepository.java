package dev.lulu.backendlocadora.repository;

import dev.lulu.backendlocadora.entity.Modelo;
import org.springframework.data.repository.ListCrudRepository;

public interface ModeloRepository extends ListCrudRepository<Modelo,Long> {
    
}
