package cl.j3duardogarci4.solicitudes.domain.usuario;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;   
    private String login;    
    private PerfilUsuario perfil;
    private LocalDateTime fechaRegistro;
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    private boolean activo;

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public PerfilUsuario getPerfil() {
        return perfil;
    }
    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }
    
    public boolean isActivo(){
        return activo;
    }
     public Long getId() {
        return id;
    }
}

