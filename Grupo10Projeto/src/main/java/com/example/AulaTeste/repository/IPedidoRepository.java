package com.example.AulaTeste.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AulaTeste.model.Pedido;

public interface IPedidoRepository extends JpaRepository <Pedido, UUID> {
}
