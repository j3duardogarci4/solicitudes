package cl.j3duardogarci4.solicitudes.application.solicitud;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

@Service
public class CrearSolicitudUseCase {
    
     private final SolicitudRepository solicitudRepository;
    
    public CrearSolicitudUseCase(SolicitudRepository solicitudRepository) {
        this.solicitudRepository =  solicitudRepository;
    }

     public void ejecutar(Solicitud solicitud){

        solicitudRepository.guardar(solicitud);
     }
    
}


