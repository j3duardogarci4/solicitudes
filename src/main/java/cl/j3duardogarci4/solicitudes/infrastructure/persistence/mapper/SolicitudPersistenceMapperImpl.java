package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.SolicitudEntity;

@Component
public class SolicitudPersistenceMapperImpl
        implements SolicitudPersistenceMapper {

    @Override
    public SolicitudEntity toEntity(Solicitud solicitud) {

        if (solicitud == null) {
            return null;
        }

        SolicitudEntity entity = new SolicitudEntity();

        entity.setId(solicitud.getId());
        entity.setDescripcion(solicitud.getDescripcion());
        entity.setFechaGeneracion(solicitud.getFechaGeneracion());
        entity.setFechaActualizacion(solicitud.getFechaActualizacion());
        entity.setEstado(solicitud.getEstado());
        entity.setIdUsuarioCreador(solicitud.getIdUsuarioCreador());
        entity.setIdSupervisorAsignado(solicitud.getIdSupervisorAsignado());

        return entity;
    }

    @Override
    public Solicitud toDomain(SolicitudEntity entity) {

        if (entity == null) {
            return null;
        }

        Solicitud solicitud = new Solicitud();

        solicitud.setId(entity.getId());
        solicitud.setDescripcion(entity.getDescripcion());
        solicitud.setFechaGeneracion(entity.getFechaGeneracion());
        solicitud.setFechaActualizacion(entity.getFechaActualizacion());
        solicitud.setEstado(entity.getEstado());
        solicitud.setIdUsuarioCreador(entity.getIdUsuarioCreador());
        solicitud.setIdSupervisorAsignado(entity.getIdSupervisorAsignado());

        return solicitud;
    }
}