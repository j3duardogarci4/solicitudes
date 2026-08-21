package cl.j3duardogarci4.solicitudes.presentation.solicitud.dto;

public class RechazarSolicitudRequest {

    private Long idSupervisor;
    private String comentario;

    public Long getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}