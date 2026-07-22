package cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import cl.j3duardogarci4.solicitudes.domain.solicitud.EstadoSolicitud;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "solicitudes")
public class SolicitudEntity {

    @Id
    private Long id;
    private String descripcion;
    private LocalDateTime fechaGeneracion;    
    private LocalDateTime fechaActualizacion;
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;
    private Long idUsuarioCreador;
    private Long idSupervisorAsignado;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }
    public Long getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(Long idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public Long getIdSupervisorAsignado() {
        return idSupervisorAsignado;
    }

    public void setIdSupervisorAsignado(Long idSupervisorAsignado) {
        this.idSupervisorAsignado = idSupervisorAsignado;
    }

    public SolicitudEntity() {
    }

    public SolicitudEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
