package com.example.AulaTeste.repository;

import com.example.AulaTeste.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IReservaRepository extends JpaRepository<ReservaModel, UUID> {}
