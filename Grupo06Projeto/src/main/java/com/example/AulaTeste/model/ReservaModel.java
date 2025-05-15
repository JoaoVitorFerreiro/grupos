package com.example.AulaTeste.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "tb_reservas")
public class ReservaModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "data_saida", nullable = false)
    private LocalDate dataSaida;

    @Column(name = "nome_animal")
    private String nomeAnimal;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public ReservaModel() {}

    public ReservaModel(LocalDate dataEntrada, LocalDate dataSaida, String nomeAnimal, String nomeUsuario, String emailUsuario) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.nomeAnimal = nomeAnimal;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
    }
}
