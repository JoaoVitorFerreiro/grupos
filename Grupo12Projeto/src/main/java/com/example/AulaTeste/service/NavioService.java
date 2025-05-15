package com.example.AulaTeste.service;

import com.example.AulaTeste.model.Navio;
import com.example.AulaTeste.repository.NavioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavioService {

    @Autowired
    private NavioRepository navioRepository;

    public void cadastrar(Navio navio) {
        navioRepository.save(navio);
    }

    public List<Navio> consultar() {
        return navioRepository.findAll();
    }

    public void atualizar(Navio navio) {
        navioRepository.save(navio);
    }
}
