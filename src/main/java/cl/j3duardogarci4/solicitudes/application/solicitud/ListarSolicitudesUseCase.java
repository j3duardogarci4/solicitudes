package cl.j3duardogarci4.solicitudes.application.solicitud;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

@Service
public class ListarSolicitudesUseCase {

    private final SolicitudRepository solicitudRepository;

    public ListarSolicitudesUseCase(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> ejecutar() {
        return solicitudRepository.listarTodas();
    }
}