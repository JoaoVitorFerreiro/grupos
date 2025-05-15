package com.example.AulaTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AulaTeste.model.FormularioModel;
import com.example.AulaTeste.repository.IFormularioRepository;

@Service
public class FormularioService {
    @Autowired
    private IFormularioRepository FormularioRepository;

    public FormularioModel criarFormulario(FormularioModel FormularioModel) {
        return FormularioRepository.save(FormularioModel);
    }

    public List<FormularioModel> listarFormulario() {
        return FormularioRepository.findAll();
    }
}
