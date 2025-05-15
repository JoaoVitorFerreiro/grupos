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
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "nm_usuario")
    private String nome;

    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email_usuario", unique = true)
    private String email;

    @Column(name = "senha_usuario")
    private String senha;

    @Column(name = "ultimoacesso")
 private String ultimoacesso;

 @Column(name = "pontuacao")
private int pontuacao;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public UserModel() {}

    public UserModel(String nome, String telefone,  String email, String senha, String ultimoacesso,
     int pontuacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.ultimoacesso = ultimoacesso;
        this.pontuacao = 0;
       
    }
    public void AdicionarPontuacao(int pontuacao){
        this.pontuacao += pontuacao;
    }
}
