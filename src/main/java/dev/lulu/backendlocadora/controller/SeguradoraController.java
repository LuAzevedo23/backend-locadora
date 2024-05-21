package dev.lulu.backendlocadora.controller;

import dev.lulu.backendlocadora.dto.SeguradoraDTO;
import dev.lulu.backendlocadora.service.SeguradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/seguradora")
public class SeguradoraController {

    @Autowired
    SeguradoraService service;

    @GetMapping
    public ResponseEntity<List<SeguradoraDTO>> buscarTodos() {
        List<SeguradoraDTO> seguradoras = service.findAll();
        return ResponseEntity.ok(seguradoras);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SeguradoraDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody SeguradoraDTO seguradoraDTO) {
        Long id = service.save(seguradoraDTO);
        return ResponseEntity.ok("Seguradora salva com sucesso!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Seguradora deletada com sucesso!");
    }
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody SeguradoraDTO seguradoraDTO) {
        service.update(seguradoraDTO);
        return ResponseEntity.ok("Seguradora atualizado com sucesso!");
    }

}
