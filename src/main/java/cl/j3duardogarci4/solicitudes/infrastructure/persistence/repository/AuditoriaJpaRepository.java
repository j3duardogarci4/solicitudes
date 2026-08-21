package cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.AuditoriaEntity;

public interface AuditoriaJpaRepository
        extends JpaRepository<AuditoriaEntity, Long> {

    List<AuditoriaEntity> findByIdSolicitud(Long idSolicitud);

    List<AuditoriaEntity> findByFechaBetween(
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );
}