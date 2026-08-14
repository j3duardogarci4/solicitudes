package cl.j3duardogarci4.solicitudes.application.solicitud;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

@Service
public class ActualizarSolicitudUseCase {

    private final SolicitudRepository solicitudRepository;

    public ActualizarSolicitudUseCase(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public boolean ejecutar(Long id, String descripcion, Long idSupervisorAsignado) {

        Optional<Solicitud> solicitudOptional =
                solicitudRepository.buscarPorId(id);

        if (solicitudOptional.isEmpty()) {
            return false;
        }

        Solicitud solicitud = solicitudOptional.get();

        solicitud.actualizar(descripcion, idSupervisorAsignado);

        solicitudRepository.actualizar(solicitud);

        return true;
    }
}
