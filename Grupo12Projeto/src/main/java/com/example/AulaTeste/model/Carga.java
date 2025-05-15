package com.example.AulaTeste.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "carga")
public class Carga {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "produto")
    private String produto;
    @Column(name = "tipo_de_carga")
    private String tipodeCarga;
    @Column(name = "quantidade")
    private float quantidade;
    @Column(name = "peso")
    private float peso;
    @Column(name = "origem")
    private String origem;
    @Column(name = "destino")
    private String destino;
    @Column(name = "navio")
    private String nomeNavio;

    public Carga(){}
    public Carga(String produto, String tipodeCarga, float quantidade, float peso, String origem, String destino, String nomeNavio){
        this.produto = produto;
        this.tipodeCarga = tipodeCarga;
        this.quantidade = quantidade;
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.nomeNavio = nomeNavio;
    }

}