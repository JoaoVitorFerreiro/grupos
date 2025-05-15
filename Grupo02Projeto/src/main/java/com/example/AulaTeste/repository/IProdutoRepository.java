package com.example.AulaTeste.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AulaTeste.model.ProdutoModel;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
