package dev.lulu.backendlocadora.dto;

import dev.lulu.backendlocadora.entity.Endereco;
import dev.lulu.backendlocadora.entity.Fabricante;

import java.time.LocalDate;

public record ModeloDTO(
        Long id,
        String nome,
        Fabricante fabricante
) {
}
