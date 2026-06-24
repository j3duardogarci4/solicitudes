package cl.j3duardogarci4.solicitudes.domain.solicitud;

import java.time.LocalDateTime;

public class Solicitud {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaGeneracion;
    private LocalDateTime fechaActualizacion;
    private EstadoSolicitud estado;
    private Long idUsuarioCreador;
    private Long idSupervisorAsignado;
}