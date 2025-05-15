package com.example.AulaTeste.controller;

import com.example.AulaTeste.model.Carga;
import com.example.AulaTeste.service.CargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargas")
public class CargaController {
    @Autowired
    private CargaService cargaService;

    @PostMapping("/")
    public void cadastrar(@RequestBody Carga carga) {
        cargaService.cadastrar(carga);
    }

    @GetMapping("/")
    public List<Carga> consultar() {
        return cargaService.consultar();
    }

    @PutMapping("/")
    public void atualizar(@RequestBody Carga carga) {
        cargaService.atualizar(carga);
    }
}