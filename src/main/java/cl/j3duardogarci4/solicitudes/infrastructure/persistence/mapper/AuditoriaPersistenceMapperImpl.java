package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import cl.j3duardogarci4.solicitudes.domain.auditoria.Auditoria;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.AuditoriaEntity;

@Component
public class AuditoriaPersistenceMapperImpl
        implements AuditoriaPersistenceMapper {

    @Override
    public AuditoriaEntity toEntity(Auditoria auditoria) {

        if (auditoria == null) {
            return null;
        }

        AuditoriaEntity entity = new AuditoriaEntity();

        entity.setId(auditoria.getId());
        entity.setIdSolicitud(auditoria.getIdSolicitud());
        entity.setIdUsuario(auditoria.getIdUsuario());
        entity.setAccion(auditoria.getAccion());
        entity.setFecha(auditoria.getFecha());

        return entity;
    }

    @Override
    public Auditoria toDomain(AuditoriaEntity entity) {

        if (entity == null) {
            return null;
        }

        Auditoria auditoria = new Auditoria();

        auditoria.setId(entity.getId());
        auditoria.setIdSolicitud(entity.getIdSolicitud());
        auditoria.setIdUsuario(entity.getIdUsuario());
        auditoria.setAccion(entity.getAccion());
        auditoria.setFecha(entity.getFecha());

        return auditoria;
    }
}