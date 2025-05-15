package site.perfume.springboot.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.UsuarioJaExiste;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.IUsuarioRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;


@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        var usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new UsuarioJaExiste();
        }
        String senhaCriptografada = BCrypt.withDefaults().hashToString(12, usuario.getSenha().toCharArray());
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioCriado = usuarioRepository.save(usuario);

        return usuarioCriado;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorEmail (String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) return false;

        return BCrypt.verifyer().verify(senha.toCharArray(), usuario.getSenha()).verified;
    }

    @Transactional
    public void deletePorEmail (String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.delete(usuario);
    }

}
