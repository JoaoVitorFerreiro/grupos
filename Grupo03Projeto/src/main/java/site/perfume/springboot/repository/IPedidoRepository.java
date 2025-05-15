package site.perfume.springboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Pedido;

public interface IPedidoRepository extends JpaRepository <Pedido, UUID> {
}
