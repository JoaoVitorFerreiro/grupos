package com.example.AulaTeste.service;

import com.example.AulaTeste.model.Carga;
import com.example.AulaTeste.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargaService {

    @Autowired
    private CargaRepository cargaRepository;

    public void cadastrar(Carga carga) {
        cargaRepository.save(carga);
    }

    public List<Carga> consultar() {
        return cargaRepository.findAll();
    }

    public void atualizar(Carga carga) {
        cargaRepository.save(carga);
    }
}
