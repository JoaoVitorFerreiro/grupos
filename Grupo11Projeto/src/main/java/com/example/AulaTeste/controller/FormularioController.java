package com.example.AulaTeste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AulaTeste.model.FormularioModel;
import com.example.AulaTeste.service.FormularioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Formulario")
public class FormularioController {

    @Autowired
    private FormularioService FormularioService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarFormulario(@RequestBody FormularioModel FormularioModel) {
        try {
            var Formulario = FormularioService.criarFormulario(FormularioModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(Formulario);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FormularioModel>> getAllUsers() {
        var Formulario = FormularioService.listarFormulario();
        if (Formulario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(Formulario);
    }
}
