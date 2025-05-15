package com.example.AulaTeste.controller;

import com.example.AulaTeste.model.ReservaModel;
import com.example.AulaTeste.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarReserva(@RequestBody ReservaModel reserva) {
        try {
            var novaReserva = reservaService.criarReserva(reserva);
            return ResponseEntity.ok(novaReserva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ReservaModel>> GetAllReservas() {
        var reservas = reservaService.ListarReservas();
        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }
}
