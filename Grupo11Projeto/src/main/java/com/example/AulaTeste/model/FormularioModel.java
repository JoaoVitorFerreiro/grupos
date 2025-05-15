package com.example.AulaTeste.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Formulario")
public class FormularioModel{
   
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

   @Column(name = "nome_dos_trabalhadores")
    private String nome_dos_trabalhadores;

    @Column(name = "nome_de_empresa")
    private String nome_de_empresa;

    @Column(name = "numero_do_ptp")
    private String numero_do_ptp;

    @Column(name  = "hora_do_inicio_e_previsao_do_termino")
    private String hora_do_inicio_e_previsao_do_termino;

    @Column(name = "setor")
    private String setor;
 
    @Column(name = "local_especifico") 
    private String local_especifico;
   
    @Column(name = "endereco_comercial") 
    private String endereco_comercial;
    
    @Column(name = "trabalho_em_altura")
    private String trabalho_em_altura;

    @Column(name = "energias_perigosas")
    private String energia_perigosas;

    @Column(name = "equipamentos_moveis")
    private String equipamentos_moveis;

    @Column(name = "icamento_de_cargas")
    private String icamento_de_cargas;
    
    @Column(name = "espaco_confinado")
    private String espaco_confinado;

    @Column(name = "outras_atividades")
    private String outras_atividades;

    @Column(name = "assinatura_do_responavel_da_equipe_de_trabalho")
    private String assinatura_do_responavel_da_equipe_de_trabalho;

    @Column(name = "assinatura_do_responsavel_do_sites")
    private String assinatura_do_responsavel_do_sites;

    @Column(name = "assinatura_do_tecnico_de_seguranca")
    private String assinatura_do_tecnico_de_seguranca;

}