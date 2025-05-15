package com.example.AulaTeste.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AulaTeste.model.Usuario;

public interface IUserRepository extends JpaRepository<Usuario, UUID> {
  Usuario findByEmail(String email);
  Usuario deleteByEmail(String email);
}
