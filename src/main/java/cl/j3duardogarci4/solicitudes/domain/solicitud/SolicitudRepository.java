package cl.j3duardogarci4.solicitudes.domain.solicitud;

import java.util.Optional;

public interface SolicitudRepository {

    Solicitud guardar(Solicitud solicitud);

    Optional<Solicitud> buscarPorId(Long id);

    void actualizar(Solicitud solicitud);

}