package cl.j3duardogarci4.solicitudes.domain.solicitud;

import java.time.LocalDateTime;
import java.util.UUID;

import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

public class SolicitudService {
    
    private final SolicitudRepository solicitudRepository;
    private final AuditoriaService auditoriaService;
    public SolicitudService(SolicitudRepository solicitudRepository, AuditoriaService auditoriaService){
       this.solicitudRepository = solicitudRepository;
       this.auditoriaService = auditoriaService;	
    } 

    public void crearSolicitud(Solicitud solicitud, Usuario usuario) {

        // Validar usuario
        validarUsuario(usuario);

        // Validar que el usuario esté activo
        validarUsuarioActivo(usuario);

        // Asignar estado borrador
        solicitud.setEstado(EstadoSolicitud.BORRADOR);

        // Registrar fecha de creación
        solicitud.setFechaGeneracion(LocalDateTime.now());

        // Guardar solicitud    
        solicitudRepository.guardar(solicitud);

        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "CREAR_SOLICITUD", usuario);
    }

    public void modificarSolicitud(Solicitud solicitud, Usuario usuario, String nuevaDescripcion) {

        // Validar que la solicitud exista
        validarSolicitud(solicitud);

        validarOperacionSobreSolicitudEnBorrador(usuario, solicitud);

        // Actualizar descripción 
        solicitud.setDescripcion(nuevaDescripcion);

        // Registrar fecha de actualización
        solicitud.setFechaActualizacion(LocalDateTime.now());

        // Guardar Solicitud
        solicitudRepository.actualizar(solicitud);

        // Registrar auditoria
        auditoriaService.registrarAccion(solicitud.getId(), "MODIFICAR_SOLICITUD", usuario);

    }

    public void enviarSolicitud(Solicitud solicitud, Usuario usuario) {

        // validar la solicitud 
        validarSolicitud(solicitud);

        validarOperacionSobreSolicitudEnBorrador(usuario, solicitud);

        // Validar información mínima 
        validarInformacionMinima(solicitud);

        // Cambiar estado a ENVIADA
        solicitud.setEstado(EstadoSolicitud.ENVIADA);

        // Guardar solicitud 
        solicitudRepository.actualizar(solicitud);

        // Registrar auditoría 
        auditoriaService.registrarAccion(solicitud.getId(), "ENVIAR_SOLICITUD", usuario);

    }

    public void crearSolicitudDesdeRechazada(Long idSolicitudRechazada, Usuario usuario) {

        // Buscar solicitud rechazada
        Solicitud solicitudRechazada = solicitudRepository.buscarPorId(idSolicitudRechazada) 
                       .orElseThrow(() ->
                                new IllegalArgumentException("Solicitud inexistente."));

        // Validar que exista 
        validarSolicitud(solicitudRechazada);
        // Validar usuario
        validarUsuario(usuario);

        // Validar usuario activo
        validarUsuarioActivo(usuario);

        // Validar que el usuario sea el creador
        validarUsuarioCreador(usuario, solicitudRechazada);

        // Validar estado RECHAZADA
        validarEstado(solicitudRechazada, EstadoSolicitud.RECHAZADA);

        // Crear nueva solicitud 
        Solicitud nuevaSolicitud = solicitudRechazada.crearNuevaSolicitud();

        // Guardar nueva solicitud
        solicitudRepository.guardar(nuevaSolicitud);
        
        // Registrar auditoria
        auditoriaService.registrarAccion(idSolicitudRechazada, "CREACION_SOLICITUD_DESDE_RECHAZADA", usuario);
    }

    public void eliminarSolicitud(Long solicitudId, Usuario usuario){

        Solicitud solicitud = obtenerSolicitud(solicitudId);
        validarOperacionSobreSolicitudEnBorrador(usuario, solicitud);

    }

    private Solicitud obtenerSolicitud(Long solicitudId){

        return solicitudRepository.buscarPorId(solicitudId)
        .orElseThrow(() ->
            new IllegalArgumentException("La solicitud no existe."));
    }
    private void validarUsuario(Usuario usuario){
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario es obligatorio.");
        }
    }
    
    private void validarUsuarioActivo(Usuario usuario){
        if (!usuario.isActivo()) {
                throw new IllegalArgumentException("El usuario está inactivo.");
                }
    }
    
    private void validarEstado(Solicitud solicitud, EstadoSolicitud estado){
        if (solicitud.getEstado() != estado){
            throw new IllegalArgumentException("La solicitud no se encuentra en el estado esperado");
        }

    }

    private void validarUsuarioCreador(Usuario usuario, Solicitud solicitud) {
        if (!solicitud.getIdUsuarioCreador().equals(usuario.getId())){
             throw new IllegalArgumentException("Solo el creador puede modificar la solicitud");
        }
    }

    private void validarSolicitud(Solicitud solicitud){
        if (solicitud == null){
            throw new IllegalArgumentException("La solicitud es obligatoria");
        }

    }

    private void validarInformacionMinima(Solicitud solicitud){
        if (solicitud.getDescripcion() == null || solicitud.getDescripcion().isBlank()) {
            throw new IllegalArgumentException("La descripción de la solicitud es obligatoria.");
        }

    }

    private void validarOperacionSobreSolicitudEnBorrador(Usuario usuario, Solicitud solicitud){

        validarUsuario(usuario);
        validarUsuarioActivo(usuario);
        validarUsuarioCreador(usuario, solicitud);
        validarEstado(solicitud, EstadoSolicitud.BORRADOR);
    }
}
