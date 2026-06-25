package cl.j3duardogarci4.solicitudes.domain.auditoria;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditoriaRepository {

    void guardar(Auditoria auditoria);

    List<Auditoria> buscarPorSolicitud(Long idSolicitud);

    List<Auditoria> buscarPorRangoFechas( LocalDateTime fechaInicio, LocalDateTime fechaFin);

}