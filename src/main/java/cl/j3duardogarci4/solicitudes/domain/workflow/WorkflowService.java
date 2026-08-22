package cl.j3duardogarci4.solicitudes.domain.workflow;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.domain.solicitud.EstadoSolicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.usuario.PerfilUsuario;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;
import cl.j3duardogarci4.solicitudes.domain.comentario.ComentarioRepository;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;


@Service
public class WorkflowService {
    private final SolicitudRepository solicitudRepository;
    private final ComentarioRepository comentarioRepository;
    private final AuditoriaService auditoriaService;
    
    
    public WorkflowService(
            SolicitudRepository solicitudRepository,          
            ComentarioRepository comentarioRepository,
            AuditoriaService  auditoriaService){
        
        
        this.solicitudRepository = solicitudRepository;
        this.comentarioRepository = comentarioRepository;
        this.auditoriaService = auditoriaService;
        
    }
    public void iniciarRevision(Solicitud solicitud, Usuario supervisor) {

        // Validar usuario
        validarUsuario(supervisor);
         
        // Validar supervisor activo
        validarUsuarioActivo(supervisor);
        
        // Validar supervisor 
        validarSupervisor(supervisor);

        // Validar estado ENVIADA
        validarEstado(solicitud, EstadoSolicitud.ENVIADA);
        
        // Asignar supervisor
        solicitud.asignarSupervisor(supervisor.getId());
        
        // Cambiar estado a EN_REVISION
        solicitud.setEstado(EstadoSolicitud.EN_REVISION); 

        // Guardar solicitud
        solicitudRepository.actualizar(solicitud);

        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "INICIAR_REVISION", supervisor);

    }
   
    public void enviarSolicitud(Solicitud solicitud, Usuario usuario){
        validarUsuario(usuario);
        validarUsuarioActivo(usuario);
        validarEstado(solicitud, EstadoSolicitud.BORRADOR);
        solicitud.setEstado(EstadoSolicitud.ENVIADA);

        solicitudRepository.actualizar(solicitud);

        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "SOLICITUD_ENVIADA", usuario);
    }
   

    public void aprobarSolicitud(Solicitud solicitud, Usuario supervisor) {

        // Validaciones
        validarUsuario(supervisor);
         
        // Validar supervisor activo
        validarUsuarioActivo(supervisor);
        
        // Validar supervisor 
        validarSupervisor(supervisor);

        // Validar estado REVISION
        validarEstado(solicitud, EstadoSolicitud.EN_REVISION);

        // Estado aprobada
        solicitud.setEstado(EstadoSolicitud.APROBADA);

        // Actualizar Solicitud
        solicitudRepository.actualizar(solicitud);

        // Registro auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "SOLICITUD_APROBADA", supervisor);
    }

    public void rechazarSolicitud(Solicitud solicitud, Usuario supervisor, Comentario comentario) {
        //Validaciones
        validarUsuario(supervisor);
        validarUsuarioActivo(supervisor);  
        validarEstado(solicitud,EstadoSolicitud.EN_REVISION);
        validarSupervisor(supervisor);

        // validar y guardar comentario
        validarComentario (comentario);

        // Completar datos del comentario
        comentario.setIdSolicitud(solicitud.getId());
        comentario.setIdSupervisor(supervisor.getId());
        comentario.setFechaRegistro(LocalDateTime.now());

        comentarioRepository.guardar(comentario);
        
         // Actualizar estado
        solicitud.setEstado(EstadoSolicitud.RECHAZADA);

        solicitudRepository.actualizar(solicitud);

       
        
        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "RECHAZAR_SOLICITUD", supervisor);

    }

    public void cerrarSolicitud(Solicitud solicitud, Usuario usuario) {

        //Validaciones
        validarUsuario(usuario);
        validarUsuarioActivo(usuario);  

        validarEstado(solicitud,EstadoSolicitud.APROBADA, EstadoSolicitud.RECHAZADA);
        
        // actualizando al estado correspondiente 
        solicitud.setEstado(EstadoSolicitud.CERRADA);

        // Actualizar solicitud
        solicitudRepository.actualizar(solicitud);

        // Registrar auditoría
        auditoriaService.registrarAccion(solicitud.getId(),"SOLICITUD_CERRADA", usuario);
    }

    public void eliminarSolicitud(Solicitud solicitud, Usuario usuario) {

         validarUsuario(usuario);
         validarUsuarioActivo(usuario);

         validarEstado(solicitud, EstadoSolicitud.BORRADOR);
         solicitud.setEstado(EstadoSolicitud.ELIMINADA);
         solicitudRepository.actualizar(solicitud);

         auditoriaService.registrarAccion(
                             solicitud.getId(),
                     "SOLICITUD_ELIMINADA",
                             usuario
                             );

         

    }

   


    private void validarComentario(Comentario comentario){
        if (comentario == null) {
            throw new IllegalArgumentException("El comentario es obligatorio.");
        }
        if (comentario.getDescripcion() == null ||  comentario.getDescripcion().isBlank()) {
            throw new IllegalArgumentException("El comentario no puede estar vacío.");
        }
    }
    
    private void validarEstado(Solicitud solicitud, EstadoSolicitud... estados){
       

        for (EstadoSolicitud estado : estados) {
            if (solicitud.getEstado() == estado) {
                return;
            }
        }
         throw new IllegalArgumentException(
             "La solicitud no se encuentra en un estado permitido"
        );
    
    }

    private void validarSupervisor(Usuario supervisor) {

        if (supervisor.getPerfil() != PerfilUsuario.SUPERVISOR) {
            throw new IllegalArgumentException(
                            "El usuario no tiene perfil de supervisor.");
        }
    }

    private void validarUsuarioActivo(Usuario supervisor){
        if (!supervisor.isActivo()) {
                throw new IllegalArgumentException(
                            "El usuario debe estar activo.");
        }
    }

    private void validarUsuario(Usuario usuario){
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario es obligatorio.");
        }
    }


}
