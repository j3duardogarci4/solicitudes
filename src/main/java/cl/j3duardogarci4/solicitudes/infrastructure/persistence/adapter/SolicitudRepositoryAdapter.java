package cl.j3duardogarci4.solicitudes.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository.SolicitudJpaRepository;

@Repository
public class SolicitudRepositoryAdapter implements SolicitudRepository {

    private final SolicitudJpaRepository solicitudJpaRepository;

    public SolicitudRepositoryAdapter(SolicitudJpaRepository solicitudJpaRepository) {
        this.solicitudJpaRepository = solicitudJpaRepository;
    }

    @Override
    public void guardar(Solicitud solicitud) {
    }

    @Override
    public Optional<Solicitud> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void actualizar(Solicitud solicitud) {
    }
}