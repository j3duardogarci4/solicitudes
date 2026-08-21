package cl.j3duardogarci4.solicitudes.application.solicitud;

import java.util.Optional;
import org.springframework.stereotype.Service;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.domain.usuario.UsuarioRepository;
import cl.j3duardogarci4.solicitudes.domain.workflow.WorkflowService;

@Service
public class IniciarRevisionUseCase {

    private final SolicitudRepository solicitudRepository;
    private final UsuarioRepository usuarioRepository;
    private final WorkflowService workflowService;

    public IniciarRevisionUseCase(
            SolicitudRepository solicitudRepository,
            UsuarioRepository usuarioRepository,
            WorkflowService workflowService) {

        this.solicitudRepository = solicitudRepository;
        this.usuarioRepository = usuarioRepository;
        this.workflowService = workflowService;
    }

    public boolean ejecutar(Long idSolicitud, Long idSupervisor) {

        Optional<Solicitud> solicitud =
                solicitudRepository.buscarPorId(idSolicitud);

        if (solicitud.isEmpty()) {
            return false;
        }

        Optional<Usuario> supervisor =
                usuarioRepository.buscarPorId(idSupervisor);

        if (supervisor.isEmpty()) {
            return false;
        }

        workflowService.iniciarRevision(
                solicitud.get(),
                supervisor.get()
        );

        return true;
    }
}