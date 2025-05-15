package com.example.AulaTeste.repository;

import com.example.AulaTeste.model.*;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
  Usuario findByEmail(String email);
  Usuario deleteByEmail(String email);
}