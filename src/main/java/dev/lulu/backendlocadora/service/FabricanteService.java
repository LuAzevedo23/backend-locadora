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
    public FabricanteDTO findById(Long id) {
        Fabricante fabricante = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Fabricante com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(fabricante);

    }

    public Long save(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = mapper.paraEntity(fabricanteDTO);
        return repository.save(fabricante).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Fabricante com id" + id + "Não foi encontrado");
        }
    }

    public Long update(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = mapper.paraEntity(fabricanteDTO);
        if (repository.existsById(fabricante.getId())) {
            return repository.save(fabricante).getId();
        } else {
            throw new RuntimeException("Fabricante com id" + fabricante.getId() + "Não foi encontrado");
        }
    }
}
