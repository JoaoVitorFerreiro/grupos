package com.example.AulaTeste.repository;

import com.example.AulaTeste.model.*;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargaRepository extends JpaRepository<Carga, UUID> {
    Carga findByProduto(String produto);
}