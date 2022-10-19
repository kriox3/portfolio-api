package ga.kriox3.ApiPortfolio.service;

import ga.kriox3.ApiPortfolio.entity.Usuario;
import ga.kriox3.ApiPortfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nu) {
        return usuarioRepository.findByNombreUsuario(nu);
    }

    public boolean existePorNombre(String nu) {
        return usuarioRepository.existsByNombreUsuario(nu);
    }

    public boolean existePorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    
    public List<Usuario> getUsuarios(){
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }
}
