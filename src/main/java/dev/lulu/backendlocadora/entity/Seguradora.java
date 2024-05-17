package dev.lulu.backendlocadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {
    @Id
    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private Double valor;
    @Column("id")
    private Endereco endereco;

}
