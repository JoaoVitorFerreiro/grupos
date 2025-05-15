package com.example.AulaTeste.service;
import com.example.AulaTeste.model.ReservaModel;
import com.example.AulaTeste.repository.IReservaRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private EmailService emailService;

    public ReservaModel criarReserva(ReservaModel reserva) {
        try {
            emailService.ConfirmacaoReserva(reserva.getEmailUsuario(), reserva.getNomeAnimal());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
        return reservaRepository.save(reserva);
    }

    public List<ReservaModel> ListarReservas() {
        return reservaRepository.findAll();
    }
}
