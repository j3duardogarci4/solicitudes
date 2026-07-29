package cl.j3duardogarci4.solicitudes.application.solicitud;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

@Service
public class BuscarSolicitudUseCase {

    private final SolicitudRepository solicitudRepository;

    public BuscarSolicitudUseCase(SolicitudRepository solicitudRepository){

        this.solicitudRepository = solicitudRepository;
    }

    public Optional<Solicitud> ejecutar(Long id) {

        return solicitudRepository.buscarPorId(id);
        
    }


}
