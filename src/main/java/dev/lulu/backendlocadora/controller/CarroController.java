package dev.lulu.backendlocadora.controller;

import dev.lulu.backendlocadora.dto.CarroDTO;
import dev.lulu.backendlocadora.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/carros")
public class CarroController {
    @Autowired
    CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> buscarTodos() {
        List<CarroDTO> carros = service.findAll();
        return ResponseEntity.ok(carros);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> save(CarroDTO carroDTO) {
        Long id = service.save(carroDTO);
        return ResponseEntity.ok("Carro salvo com sucesso!");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(Long id) {
        service.delete(id);
        return ResponseEntity.ok("Carro deletado com sucesso!");
    }
    @PatchMapping
    public ResponseEntity<String> update(CarroDTO carroDTO) {
        Long id = service.save(carroDTO);
        return ResponseEntity.ok("Carro atualizado com sucesso!");
    }

}
