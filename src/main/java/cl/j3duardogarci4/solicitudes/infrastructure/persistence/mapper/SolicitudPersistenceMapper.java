package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.SolicitudEntity;

public interface SolicitudPersistenceMapper {

    SolicitudEntity toEntity(Solicitud solicitud);

    Solicitud toDomain(SolicitudEntity entity);

}