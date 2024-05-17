package dev.lulu.backendlocadora.repository;

import dev.lulu.backendlocadora.entity.Cliente;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ListCrudRepository<Cliente,Long> {


}
