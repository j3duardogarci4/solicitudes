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

    public void modificarSolicitud(Solicitud solicitud, Usuario usuario, String nuevaDescripcion) {

        // Validar que la solicitud exista
        if (solicitud == null){
            throw new IllegalArgumentException("La solicitud es obligatoria");
        }

        // Validar usuario
        if (!usuario.isActivo()){
            throw new IllegalArgumentException("El usuario está inactivo");
        }       

        // Validar que el usuario sea el creador
        if (!solicitud.getIdUsuarioCreador().equals(usuario.getId())){
             throw new IllegalArgumentException("Solo el creador puede modificar la solicitud");
        }

        // Validar que el estado sea BORRADOR
        if (!(solicitud.getEstado() !=   EstadoSolicitud.BORRADOR)){
            throw new IllegalArgumentException("Solo las solicitudes en estado BORRADOR pueden modificarse");
        }

        // Actualizar descripción 
        solicitud.setDescripcion(nuevaDescripcion);

        // Registrar fecha de actualización
        solicitud.setFechaGeneracion(LocalDateTime.now());

        // Guardar Solicitud
        solictudRepository.actualizar(solicitud);


        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "MODIFICAR_SOLICITUD", usuario);

        


    }

    public void enviarSolicitud(Solicitud solicitud, Usuario usuario) {

    }

    public void crearSolicitudDesdeRechazada(Long idSolicitudRechazada, Usuario usuario) {

    }

}
