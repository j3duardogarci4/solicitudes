package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.UsuarioEntity;

@Component
public class UsuarioPersistenceMapperImpl
        implements UsuarioPersistenceMapper {

    @Override
    public UsuarioEntity toEntity(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioEntity entity = new UsuarioEntity();

        entity.setId(usuario.getId());
        entity.setLogin(usuario.getLogin());
        entity.setPerfil(usuario.getPerfil());
        entity.setFechaRegistro(usuario.getFechaRegistro());
        entity.setActivo(usuario.isActivo());

        return entity;
    }

    @Override
    public Usuario toDomain(UsuarioEntity entity) {

        if (entity == null) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId(entity.getId());
        usuario.setLogin(entity.getLogin());
        usuario.setPerfil(entity.getPerfil());
        usuario.setFechaRegistro(entity.getFechaRegistro());
        usuario.setActivo(entity.isActivo());

        return usuario;
    }
}