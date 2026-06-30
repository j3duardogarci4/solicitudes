package cl.j3duardogarci4.solicitudes.domain.usuario;

import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final AuditoriaService auditoriaService;
    
    public void UsuarioService(UsuarioRepository usuarioRepository, AuditoriaService auditoriaService{
        this.usuarioRepository = usuarioRepository;
        this.auditoriaService = auditoriaService;
    };
    public void crearUsuario(Usuario usuario) {

    }

    public void asignarPerfilUsuario(Usuario usuario, PerfilUsuario perfil ) {

    }

    public void deshabilitarUsuario(Long idUsuario, String motivo) {

    }

}
