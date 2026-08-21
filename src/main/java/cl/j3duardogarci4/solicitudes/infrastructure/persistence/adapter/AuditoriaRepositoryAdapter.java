package cl.j3duardogarci4.solicitudes.infrastructure.persistence.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import cl.j3duardogarci4.solicitudes.domain.auditoria.Auditoria;
import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.AuditoriaEntity;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper.AuditoriaPersistenceMapper;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository.AuditoriaJpaRepository;

@Repository
public class AuditoriaRepositoryAdapter implements AuditoriaRepository {

    private final AuditoriaJpaRepository auditoriaJpaRepository;
    private final AuditoriaPersistenceMapper auditoriaPersistenceMapper;

    public AuditoriaRepositoryAdapter(
            AuditoriaJpaRepository auditoriaJpaRepository,
            AuditoriaPersistenceMapper auditoriaPersistenceMapper) {

        this.auditoriaJpaRepository = auditoriaJpaRepository;
        this.auditoriaPersistenceMapper = auditoriaPersistenceMapper;
    }

    @Override
    public void guardar(Auditoria auditoria) {

        AuditoriaEntity entity =
                auditoriaPersistenceMapper.toEntity(auditoria);

        auditoriaJpaRepository.save(entity);
    }

    @Override
    public List<Auditoria> buscarPorSolicitud(Long idSolicitud) {

        return auditoriaJpaRepository
                .findByIdSolicitud(idSolicitud)
                .stream()
                .map(auditoriaPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Auditoria> buscarPorRangoFechas(
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {

        return auditoriaJpaRepository
                .findByFechaBetween(fechaInicio, fechaFin)
                .stream()
                .map(auditoriaPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }
}