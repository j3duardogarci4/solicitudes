package cl.j3duardogarci4.solicitudes.domain.solicitud;

import java.time.LocalDateTime;

import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

public class SolicitudService {
    
    private final SolicitudRepository solictudRepository;
    private final AuditoriaService auditoriaService;
    public SolicitudService(SolicitudRepository solicitudRepository, AuditoriaService auditoriaService){
       this.solictudRepository = solicitudRepository;
       this.auditoriaService = auditoriaService;	
    } 

    public void crearSolicitud(Solicitud solicitud, Usuario usuario) {

        // Validar usuario
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario es obligatorio.");
        }
        // Validar que el usuario esté activo
        if (!usuario.isActivo()) {
                throw new IllegalArgumentException("El usuario está inactivo.");
                }

        // Asignar estado borrador
        solicitud.setEstado(EstadoSolicitud.BORRADOR);

        // Registrar fecha de creación
        solicitud.setFechaGeneracion(LocalDateTime.now());

        // Guardar solicitud    
        solictudRepository.guardar(solicitud);

        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "CREAR_SOLICITUD", usuario);
    }

    public void modificarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void enviarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void crearSolicitudDesdeRechazada(Long idSolicitudRechazada, Usuario usuario) {

    }

}
