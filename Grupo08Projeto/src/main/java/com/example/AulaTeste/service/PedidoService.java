package com.example.AulaTeste.service;

import org.springframework.stereotype.Service;
import com.example.AulaTeste.model.Pedido;
import com.example.AulaTeste.repository.IPedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final IPedidoRepository pedidoRepository;
    private final EmailService emailService;

    public PedidoService(IPedidoRepository pedidoRepository, EmailService emailService) {
        this.pedidoRepository = pedidoRepository;
        this.emailService = emailService;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        var pedidoSalvo = pedidoRepository.save(pedido);
        try {
            emailService.enviarEmailCompra(pedido.getEmailUsuario(), pedido.getProduto());
        } catch (Exception e) {
            System.err.println("Erro ao enviar email: " + e.getMessage());
        }
        
        return pedidoSalvo;
    }
}