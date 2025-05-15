package com.example.AulaTeste.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "status_pedido")
    private String status;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "produto")
    private String produto;

    public Pedido(String endereco, double valor, LocalDateTime dataPedido, String status, String nomeUsuario, String emailUsuario, String produto) {
        this.endereco = endereco;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.status = status;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.produto = produto;
    }
    public Pedido() {
    }
}
