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
    
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Long getIdSupervisorAsignado() {
        return idSupervisorAsignado;
    }

    public void setIdSupervisorAsignado(Long idSupervisorAsignado) {
        this.idSupervisorAsignado = idSupervisorAsignado;
    }
   
    
    public void asignarSupervisor(Long idSupervisorAsignado){
        this.idSupervisorAsignado = idSupervisorAsignado;
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
    public void setIdUsuarioCreador(Long idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }


    public Solicitud crearNuevaSolicitud() {

        Solicitud nueva = new Solicitud();
        nueva.setDescripcion(this.descripcion);
        nueva.setIdUsuarioCreador(this.idUsuarioCreador);
        nueva.setEstado(EstadoSolicitud.BORRADOR);
        nueva.setFechaGeneracion(LocalDateTime.now());
        return nueva;
        
    }
}