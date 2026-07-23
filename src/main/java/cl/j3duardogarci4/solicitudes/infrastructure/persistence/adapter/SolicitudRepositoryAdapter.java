package cl.j3duardogarci4.solicitudes.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository.SolicitudJpaRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.SolicitudEntity;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper.SolicitudPersistenceMapper;


@Repository
public class SolicitudRepositoryAdapter implements SolicitudRepository {

    private final SolicitudJpaRepository solicitudJpaRepository;
    private final SolicitudPersistenceMapper mapper;
    

    public SolicitudRepositoryAdapter(SolicitudJpaRepository solicitudJpaRepository, SolicitudPersistenceMapper mapper) {
        this.solicitudJpaRepository = solicitudJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void guardar(Solicitud solicitud) {
         SolicitudEntity entity = mapper.toEntity(solicitud);
         solicitudJpaRepository.save(entity);
    }

    @Override
    public Optional<Solicitud> buscarPorId(Long id) {
        return solicitudJpaRepository
           .findById(id)
           .map(mapper::toDomain);
    }

    @Override
    public void actualizar(Solicitud solicitud) {
        SolicitudEntity entity = mapper.toEntity(solicitud);
        solicitudJpaRepository.save(entity);
        
    }
}