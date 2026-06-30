package cl.j3duardogarci4.solicitudes.domain.solicitud;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

public class SolicitudService {
    
    private final SolicituRepository solictudRepository;
    private final AuditoriaService auditoriaSErvice;
    public SolicitudService(SolicituRepository solictudRepository, AuditoriaService auditoriaSErvice){
       this.solicitudRepository = solicitudRepository;
       this.auditoriaService = auditoriaService;	
    } 

    public void crearSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void modificarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void enviarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void crearSolicitudDesdeRechazada(Long idSolicitudRechazada, Usuario usuario) {

    }

}
