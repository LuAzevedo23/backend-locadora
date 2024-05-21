
package dev.lulu.backendlocadora.service;
import dev.lulu.backendlocadora.dto.SeguradoraDTO;
import dev.lulu.backendlocadora.entity.Seguradora;
import dev.lulu.backendlocadora.mapper.SeguradoraMapper;
import dev.lulu.backendlocadora.repository.SeguradoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguradoraService {
    @Autowired
    private SeguradoraRepository repository;
    @Autowired
    private SeguradoraMapper mapper;

    public List<SeguradoraDTO> findAll(){
        List<Seguradora> seguradoras = repository.findAll();
        return mapper.paraDTO(seguradoras);
    }
    public SeguradoraDTO findById(Long id) {
        Seguradora seguradora = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Seguradora com id" + id + "Não foi encontrada"));
        return mapper.paraDTO(seguradora);

    }

    public Long save(SeguradoraDTO seguradoraDTO) {
        Seguradora seguradora = mapper.paraEntity(seguradoraDTO);
        return repository.save(seguradora).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Seguradora com id" + id + "Não foi encontrada");
        }
    }

    public Long update(SeguradoraDTO seguradoraDTO) {
        Seguradora seguradora = mapper.paraEntity(seguradoraDTO);
        if (repository.existsById(seguradora.getId())) {
            return repository.save(seguradora).getId();
        } else {
            throw new RuntimeException("Seguradora com id" + seguradora.getId() + "Não foi encontrada");
        }
    }
}
