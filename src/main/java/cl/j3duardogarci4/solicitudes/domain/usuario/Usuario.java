package cl.j3duardogarci4.solicitudes.domain.usuario;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;
    private String login;
    private PerfilUsuario perfil;
    private LocalDateTime fechaRegistro;
    private Boolean activo;

    public Boolean isActivo(){
        return activo;
    }
}

