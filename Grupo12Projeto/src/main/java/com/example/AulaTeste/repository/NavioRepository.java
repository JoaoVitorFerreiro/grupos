

package com.example.AulaTeste.repository;

import com.example.AulaTeste.model.*;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NavioRepository extends JpaRepository<Navio, UUID> {
}