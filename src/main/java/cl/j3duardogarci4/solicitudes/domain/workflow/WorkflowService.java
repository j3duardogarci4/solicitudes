package cl.j3duardogarci4.solicitudes.domain.workflow;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;
import cl.j3duardogarci4.solicitudes.domain.comentario.ComentarioRepository;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

public class WorkflowService {
    private final SolicitudRepository solicitudRepository;
    private final ComentarioRepository comentarioRepository;
    private final AuditoriaRepository = auditoriaRepository;
    
    public WorkflowService(
            SolicitudRepository solicitudRepository,          
            ComentarioRepository comentarioRepository,
            AuditoriaRepository  auditoriaRepository){
        
        
        this.solicitudRepository = solicitudRepository;
        this.comentarioRepository = comentarioRepository;
        this.auditoriaRepository = auditoriaRepository;
        
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
