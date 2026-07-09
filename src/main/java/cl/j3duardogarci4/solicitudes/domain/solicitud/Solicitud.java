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
    
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public EstadoSolicitud getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoSolicitud estado){
       this.estado = estado;    
    }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion){
        this.fechaGeneracion = fechaGeneracion;
    }
     public Long getId() {
        return id;
    }

    public Long getIdUsuarioCreador(){
        return idUsuarioCreador;
    }
        public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}