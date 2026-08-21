package cl.j3duardogarci4.solicitudes.domain.auditoria;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {
    private final AuditoriaRepository auditoriaRepository;
    public AuditoriaService(AuditoriaRepository auditoriaRepository){
        this.auditoriaRepository = auditoriaRepository;
    }

    public void registrarAccion(Long idSolicitud, String accion, Usuario usuario) {

        Auditoria auditoria = new Auditoria();

        auditoria.setIdSolicitud(idSolicitud);
        auditoria.setIdUsuario(usuario.getId());
        auditoria.setAccion(accion);
        auditoria.setFecha(LocalDateTime.now());

        auditoriaRepository.guardar(auditoria);
        
    }

    public void consultarHistorial(Long idSolicitud) {


    }


}
