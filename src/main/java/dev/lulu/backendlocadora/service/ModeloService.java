package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.ModeloDTO;import dev.lulu.backendlocadora.entity.Cliente;
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
}
