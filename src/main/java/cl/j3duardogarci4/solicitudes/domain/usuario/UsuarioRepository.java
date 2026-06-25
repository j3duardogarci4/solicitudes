package cl.j3duardogarci4.solicitudes.domain.usuario;

import java.util.Optional;

public interface UsuarioRepository {
 
    void guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorLogin(String login);

    void actualizar(Usuario usuario);

}