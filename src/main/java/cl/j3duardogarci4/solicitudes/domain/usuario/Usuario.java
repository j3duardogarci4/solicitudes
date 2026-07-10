package cl.j3duardogarci4.solicitudes.domain.usuario;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;
    private String login;
    private PerfilUsuario perfil;
    private LocalDateTime fechaRegistro;
    private Boolean activo;

    public PerfilUsuario getPerfil() {
        return perfil;
    }
    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }
    
    public Boolean isActivo(){
        return activo;
    }
     public Long getId() {
        return id;
    }
}

