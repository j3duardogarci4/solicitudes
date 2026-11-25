package cl.j3duardogarci4.solicitudes.domain.solicitud;

import java.util.Optional;
import java.util.List;

public interface SolicitudRepository {

    Solicitud guardar(Solicitud solicitud);

    Optional<Solicitud> buscarPorId(Long id);

    List <Solicitud> listarTodas();
    
    void actualizar(Solicitud solicitud);
    
}