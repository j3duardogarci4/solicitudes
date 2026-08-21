package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.ComentarioEntity;

@Component
public class ComentarioPersistenceMapperImpl
        implements ComentarioPersistenceMapper {

    @Override
    public ComentarioEntity toEntity(Comentario comentario) {

        if (comentario == null) {
            return null;
        }

        ComentarioEntity entity = new ComentarioEntity();

        entity.setId(comentario.getId());
        entity.setDescripcion(comentario.getDescripcion());
        entity.setIdSolicitud(comentario.getIdSolicitud());
        entity.setIdSupervisor(comentario.getIdSupervisor());
        entity.setFechaRegistro(comentario.getFechaRegistro());

        return entity;
    }

    @Override
    public Comentario toDomain(ComentarioEntity entity) {

        if (entity == null) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setId(entity.getId());
        comentario.setDescripcion(entity.getDescripcion());
        comentario.setIdSolicitud(entity.getIdSolicitud());
        comentario.setIdSupervisor(entity.getIdSupervisor());
        comentario.setFechaRegistro(entity.getFechaRegistro());

        return comentario;
    }
}