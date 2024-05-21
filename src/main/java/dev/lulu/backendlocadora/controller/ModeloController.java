package dev.lulu.backendlocadora.controller;

import dev.lulu.backendlocadora.dto.ModeloDTO;
import dev.lulu.backendlocadora.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/modelo")
public class ModeloController {

    @Autowired
    ModeloService service;

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> buscarTodos() {
        List<ModeloDTO> modelos = service.findAll();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ModeloDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ModeloDTO modeloDTO) {
        Long id = service.save(modeloDTO);
        return ResponseEntity.ok("Modelo salvo com sucesso!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Modelo deletado com sucesso!");
    }
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody ModeloDTO modeloDTO) {
        service.update(modeloDTO);
        return ResponseEntity.ok("Modelo atualizado com sucesso!");
    }

}
