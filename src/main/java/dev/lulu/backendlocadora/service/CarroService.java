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
    public CarroDTO findById(Long id) {
        Carro carro = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Carro com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(carro);

    }

    public Long save(CarroDTO carroDTO) {
        Carro carro = mapper.paraEntity(carroDTO);
        return repository.save(carro).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Carro com id" + id + "Não foi encontrado");
        }
    }
    public Long update (CarroDTO carroDTO) {
        Carro carro = mapper.paraEntity(carroDTO);
        if (repository.existsById(carro.getId())) {
            return repository.save(carro).getId();
        } else {
            throw new RuntimeException("Carro com id" + carro.getId() + "Não foi encontrado");
        }
    }

}
