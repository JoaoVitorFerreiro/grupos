package site.perfume.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.model.Pedido;
import site.perfume.springboot.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> fazerPedido(@RequestBody Pedido pedido) {
        var order = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

   @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        var pedidos = pedidoService.listarTodos();
        if (pedidos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(pedidos);
    }
}
