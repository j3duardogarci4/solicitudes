package cl.j3duardogarci4.solicitudes.application.solicitud;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.CrearSolicitudRequest;


@Service
public class CrearSolicitudUseCase {
    
    private final SolicitudRepository solicitudRepository;
    
    public CrearSolicitudUseCase(SolicitudRepository solicitudRepository) {
        this.solicitudRepository =  solicitudRepository;
    }

    public Solicitud ejecutar(Solicitud solicitud){




        return solicitudRepository.guardar(solicitud);
     }

    public Solicitud ejecutar(CrearSolicitudRequest request){
        
        Solicitud solicitud = new Solicitud();
        solicitud.setDescripcion(request.getDescripcion());
        solicitud.setIdUsuarioCreador(request.getIdUsuarioCreador());
        solicitud.setIdSupervisorAsignado(request.getIdSupervisorAsignado());

        solicitud = solicitud.crearNuevaSolicitud();
        
        return solicitudRepository.guardar(solicitud);

    }
    
}


