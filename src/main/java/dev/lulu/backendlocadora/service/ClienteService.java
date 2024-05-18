package dev.lulu.backendlocadora.service;

import dev.lulu.backendlocadora.dto.ClienteDTO;
import dev.lulu.backendlocadora.entity.Cliente;
import dev.lulu.backendlocadora.mapper.ClienteMapper;
import dev.lulu.backendlocadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;

    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = repository.findAll();
        return mapper.paraDTO(clientes);
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(cliente);

    }

    public Long save(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.paraEntity(clienteDTO);
        return repository.save(cliente).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente com id" + id + "Não foi encontrado");
        }
    }
    public Long update (ClienteDTO clienteDTO) {
        Cliente cliente = mapper.paraEntity(clienteDTO);
        if (repository.existsById(cliente.getId())) {
           return repository.save(cliente).getId();
        } else {
            throw new RuntimeException("Cliente com id" + cliente.getId() + "Não foi encontrado");
        }
    }
}
