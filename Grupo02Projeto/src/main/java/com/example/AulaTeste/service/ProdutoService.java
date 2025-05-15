package com.example.AulaTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AulaTeste.model.ProdutoModel;
import com.example.AulaTeste.repository.IProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private IProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel ProdutoModel) {
        return produtoRepository.save(ProdutoModel);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }
}