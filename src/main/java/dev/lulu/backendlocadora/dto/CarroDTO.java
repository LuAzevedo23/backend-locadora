package dev.lulu.backendlocadora.dto;

import dev.lulu.backendlocadora.entity.Fabricante;
import dev.lulu.backendlocadora.entity.Modelo;

public record CarroDTO(
        Long id,
        String ano,
        String cor,
        String placa,
        Double valorLocacao,
        Boolean disponivel,
        Fabricante fabricante,
        Modelo modelo
) {
}

