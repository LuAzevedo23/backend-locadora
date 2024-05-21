package dev.lulu.backendlocadora.repository;

import dev.lulu.backendlocadora.entity.Carro;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends ListCrudRepository<Carro, Long> {

    
}
