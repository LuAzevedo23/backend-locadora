package dev.lulu.backendlocadora.dto;

import dev.lulu.backendlocadora.entity.Endereco;

public record SeguradoraDTO(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email,
        Double valor,
        Endereco endereco

) {
}
