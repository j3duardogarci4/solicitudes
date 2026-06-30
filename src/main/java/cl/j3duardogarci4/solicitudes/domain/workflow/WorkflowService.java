package cl.j3duardogarci4.solicitudes.domain.workflow;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

public class WorkflowService {
    private final UsuarioRepository usuarioRepository;
    private final SolicitudRepository solicitudRepository;
    private final ComentarioRepository comentarioRepository;
    
    public WorkflowService(
            SolicitudRepository solicitudRepository, 
            UsuarioRepository usuarioRepository, 
            ComentarioRepository comentarioRepository){
        
        this.usuarioRepository = usuarioRepository;
        this.solicitudRepository = solicitudRepository;
        this.comentarioRepository = comentarioRepository;
        
    }
    public void iniciarRevision(Solicitud solicitud, Usuario usuario) {

    }

    public void aprobarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void rechazarSolicitud(Solicitud solicitud, Usuario usuario, Comentario comentario) {

    }

    public void cerrarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void eliminarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

}
