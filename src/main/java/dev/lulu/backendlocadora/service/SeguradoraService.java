
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
}
