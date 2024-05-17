package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.EnderecoDTO;
import dev.lulu.backendlocadora.entity.Endereco;
import dev.lulu.backendlocadora.mapper.EnderecoMapper;
import dev.lulu.backendlocadora.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private EnderecoMapper mapper;

    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecos = repository.findAll();
        return mapper.paraDTO(enderecos);
    }
}
