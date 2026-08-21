package cl.j3duardogarci4.solicitudes.application.solicitud;

import java.util.Optional;
import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.domain.usuario.UsuarioRepository;
import cl.j3duardogarci4.solicitudes.domain.workflow.WorkflowService;


@Service
public class AprobarSolicitudUseCase {
    private final SolicitudRepository solicitudRepository;
    private final WorkflowService workflowService;
    private final UsuarioRepository usuarioRepository;

    public AprobarSolicitudUseCase(
          SolicitudRepository solicitudRepository,
          WorkflowService workflowService,
          UsuarioRepository usuarioRepository){

            this.solicitudRepository = solicitudRepository;
            this.usuarioRepository = usuarioRepository;
            this.workflowService = workflowService;
    }

    public boolean ejecutar(Long idSolicitud, Long idSupervisor){

        Optional<Solicitud> solicitud =  solicitudRepository.buscarPorId(idSolicitud);

        if (solicitud.isEmpty()){
              return false;
          }

        Optional<Usuario> supervisor =   usuarioRepository.buscarPorId(idSupervisor);

        if (supervisor.isEmpty()) {
            return false;
        }

        workflowService.aprobarSolicitud(solicitud.get(), supervisor.get());
         
        return true;
    
        }

    

}
