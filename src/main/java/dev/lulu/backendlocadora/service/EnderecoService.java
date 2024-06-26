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

    public List<EnderecoDTO> findAll() {
        List<Endereco> enderecos = repository.findAll();
        return mapper.paraDTO(enderecos);
    }

    public EnderecoDTO findById(Long id) {
        Endereco endereco = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Endereco com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(endereco);

    }

    public Long save(EnderecoDTO enderecoDTO) {
        Endereco endereco = mapper.paraEntity(enderecoDTO);
        return repository.save(endereco).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Endereco com id" + id + "Não foi encontrado");
        }
    }

    public Long update(EnderecoDTO enderecoDTO) {
        Endereco endereco = mapper.paraEntity(enderecoDTO);
        if (repository.existsById(endereco.getId())) {
            return repository.save(endereco).getId();
        } else {
            throw new RuntimeException("Endereco com id" + endereco.getId() + "Não foi encontrado");
        }
    }
}
