package dev.lulu.backendlocadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    private String ano;
    private String cor;
    private String placa;
    private Double valorLocacao;
    private Boolean disponivel;
    @Column("id")
    private Fabricante fabricante;
    @Column("id")
    private Modelo modelo;

}
