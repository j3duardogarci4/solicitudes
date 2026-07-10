package cl.j3duardogarci4.solicitudes.domain.comentario;

import java.time.LocalDateTime;

public class Comentario {

    private Long id;
    private String descripcion;
    private Long idSolicitud;
    private Long idSupervisor;
    private LocalDateTime fechaRegistro;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}