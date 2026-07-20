package cl.j3duardogarci4.solicitudes.domain.auditoria;

import java.time.LocalDateTime;

public class Auditoria {

    private Long id;
    private Long idSolicitud;
    private Long idUsuario;
    private String accion;
    private LocalDateTime fecha;
}