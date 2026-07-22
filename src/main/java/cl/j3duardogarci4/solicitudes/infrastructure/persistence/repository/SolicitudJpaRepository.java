package cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.SolicitudEntity;

public interface SolicitudJpaRepository
        extends JpaRepository<SolicitudEntity, Long> {

}