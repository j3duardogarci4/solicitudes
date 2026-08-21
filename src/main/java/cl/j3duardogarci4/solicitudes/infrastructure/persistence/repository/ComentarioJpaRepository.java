package cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.ComentarioEntity;

public interface ComentarioJpaRepository
        extends JpaRepository<ComentarioEntity, Long> {

    List<ComentarioEntity> findByIdSolicitud(Long idSolicitud);

}