package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.ModeloDTO;
import dev.lulu.backendlocadora.entity.Modelo;
import dev.lulu.backendlocadora.mapper.ModeloMapper;
import dev.lulu.backendlocadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository repository;
    @Autowired
    private ModeloMapper mapper;

    public List<ModeloDTO> findAll(){
        List<Modelo> modelos = repository.findAll();
        return mapper.paraDTO(modelos);
    }
    public ModeloDTO findById(Long id) {
        Modelo modelo = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Modelo com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(modelo);

    }

    public Long save(ModeloDTO modeloDTO) {
        Modelo modelo = mapper.paraEntity(modeloDTO);
        return repository.save(modelo).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Modelo com id" + id + "Não foi encontrado");
        }
    }

    public Long update(ModeloDTO modeloDTO) {
        Modelo modelo = mapper.paraEntity(modeloDTO);
        if (repository.existsById(modelo.getId())) {
            return repository.save(modelo).getId();
        } else {
            throw new RuntimeException("Modelo com id" + modelo.getId() + "Não foi encontrado");
        }
    }
}
