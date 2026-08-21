package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.ComentarioEntity;

public interface ComentarioPersistenceMapper {

   ComentarioEntity toEntity(Comentario comentario);
   Comentario toDomain(ComentarioEntity entity);

}


