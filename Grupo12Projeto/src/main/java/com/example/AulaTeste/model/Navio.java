package com.example.AulaTeste.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "navio")
public class Navio {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "bandeira")
    private String bandeira;

    @Column(name = "companhia")
    private String companhia;

    @Column(name = "ano_construcao")
    private int anoConstrucao;

    @Column(name = "comprimento")
    private double comprimento;

    @Column(name = "largura")
    private double largura;

    @Column(name = "capacidade")
    private double capacidade;

    @Column(name = "tipo")
    private String tipo;

    public Navio() {}

    public Navio(String nome, String bandeira, String companhia, int anoConstrucao,
                 double comprimento, double largura, double capacidade, String tipo) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.companhia = companhia;
        this.anoConstrucao = anoConstrucao;
        this.comprimento = comprimento;
        this.largura = largura;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }
}

