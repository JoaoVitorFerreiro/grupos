package site.perfume.springboot.service;

import org.springframework.stereotype.Service;
import site.perfume.springboot.model.Pedido;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.IPedidoRepository;
import site.perfume.springboot.repository.IUsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final IPedidoRepository pedidoRepository;
    private final IUsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public PedidoService(IPedidoRepository pedidoRepository, IUsuarioRepository usuarioRepository, EmailService emailService) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        // Verificar se o usuário existe
        if (pedido.getUsuario() == null || pedido.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Usuário não informado");
        }
        
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(pedido.getUsuario().getId());
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        
        // Definir data do pedido se não estiver definida
        if (pedido.getDataPedido() == null) {
            pedido.setDataPedido(LocalDateTime.now());
        }
        
        // Definir status padrão se não estiver definido
        if (pedido.getStatus() == null || pedido.getStatus().isEmpty()) {
            pedido.setStatus("PENDENTE");
        }
        
        // Salvar o pedido
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        
        // Enviar email de confirmação
        try {
            Usuario usuario = usuarioOpt.get();
            emailService.enviarEmailCompra(usuario.getEmail(), usuario.getNome());
        } catch (Exception e) {
            // Log do erro, mas não impede a criação do pedido
            System.err.println("Erro ao enviar email: " + e.getMessage());
        }
        
        return pedidoSalvo;
    }
}