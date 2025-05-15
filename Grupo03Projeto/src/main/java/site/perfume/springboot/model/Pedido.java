package site.perfume.springboot.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "status_pedido")
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Pedido(String endereco, double valor, LocalDateTime dataPedido, String status, Usuario usuario) {
        this.endereco = endereco;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.status = status;
        this.usuario = usuario;
    }
    public Pedido() {
    }
}
