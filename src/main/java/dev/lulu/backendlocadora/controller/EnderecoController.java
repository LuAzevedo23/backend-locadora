package dev.lulu.backendlocadora.controller;

import dev.lulu.backendlocadora.dto.ClienteDTO;
import dev.lulu.backendlocadora.dto.EnderecoDTO;
import dev.lulu.backendlocadora.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> buscarTodos() {
        List<EnderecoDTO> enderecos = service.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EnderecoDTO enderecoDTO) {
        Long id = service.save(enderecoDTO);
        return ResponseEntity.ok("Endereco salvo com sucesso!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Endereco deletado com sucesso!");
    }
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody EnderecoDTO enderecoDTO) {
        service.update(enderecoDTO);
        return ResponseEntity.ok("Endereco atualizado com sucesso!");
    }

}
