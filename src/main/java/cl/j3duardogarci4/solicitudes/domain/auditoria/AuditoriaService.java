package cl.j3duardogarci4.solicitudes.domain.auditoria;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

public class AuditoriaService {
    private final AuditoriaRepository auditoriaRepository;
    public AuditoriaService(AuditoriaRepository auditoriaRepository){
        this.auditoriaRepository = auditoriaRepository;
    }

    public void registrarAccion(Long idSolicitud, String accion, Usuario usuario) {

    }

    public void consultarHistorial(Long idSolicitud) {

    }

}
