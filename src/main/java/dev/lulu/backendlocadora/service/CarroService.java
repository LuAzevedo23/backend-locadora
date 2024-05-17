package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.CarroDTO;
import dev.lulu.backendlocadora.entity.Carro;
import dev.lulu.backendlocadora.mapper.CarroMapper;
import dev.lulu.backendlocadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository repository;
    @Autowired
    private CarroMapper mapper;

    public List<CarroDTO> findAll(){
        List<Carro> carros = repository.findAll();
        return mapper.paraDTO(carros);
    }
}
