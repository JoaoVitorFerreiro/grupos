package com.example.AulaTeste.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID numero_pedidoa;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private String valor;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public ProdutoModel() {}

    public ProdutoModel(String nome, String tipo, String valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }
}
