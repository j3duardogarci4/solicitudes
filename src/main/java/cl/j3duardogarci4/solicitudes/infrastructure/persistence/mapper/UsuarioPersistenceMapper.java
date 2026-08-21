package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.UsuarioEntity;

public interface UsuarioPersistenceMapper {

    UsuarioEntity toEntity(Usuario usuario);

    Usuario toDomain(UsuarioEntity entity);
}