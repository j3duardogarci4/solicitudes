package cl.j3duardogarci4.solicitudes.presentation.solicitud.dto;

public class CrearSolicitudRequest {

    private String descripcion;
    private Long idUsuarioCreador;
    private Long idSupervisorAsignado;

    public CrearSolicitudRequest() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}


