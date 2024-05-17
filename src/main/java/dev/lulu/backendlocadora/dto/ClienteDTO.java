package dev.lulu.backendlocadora.dto;

import dev.lulu.backendlocadora.entity.Endereco;
import java.time.LocalDate;

public record ClienteDTO(
        Long id,
        String nome,
        String rg,
        String cpf,
        String cnh,
        String telefone,
        String email,
        LocalDate cnhVencimento,
        Endereco endereco
) {
}
