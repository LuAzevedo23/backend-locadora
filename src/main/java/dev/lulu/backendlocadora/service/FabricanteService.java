package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.FabricanteDTO;
import dev.lulu.backendlocadora.entity.Fabricante;
import dev.lulu.backendlocadora.mapper.FabricanteMapper;
import dev.lulu.backendlocadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {
    @Autowired
    private FabricanteRepository repository;
    @Autowired
    private FabricanteMapper mapper;

    public List<FabricanteDTO> findAll(){
        List<Fabricante> fabricantes = repository.findAll();
        return mapper.paraDTO(fabricantes);
    }
}
