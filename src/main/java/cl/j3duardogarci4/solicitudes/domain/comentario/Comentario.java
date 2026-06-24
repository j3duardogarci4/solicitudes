package cl.j3duardogarci4.solicitudes.domain.comentario;

import java.time.LocalDateTime;

public class Comentario {

    private Long id;
    private String comentario;
    private Long idSolicitud;
    private Long idSupervisor;
    private LocalDateTime fechaRegistro;
}