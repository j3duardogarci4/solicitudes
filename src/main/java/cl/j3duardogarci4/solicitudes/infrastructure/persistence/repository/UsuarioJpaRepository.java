package cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.UsuarioEntity;

public interface UsuarioJpaRepository
        extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByLogin(String login);

}