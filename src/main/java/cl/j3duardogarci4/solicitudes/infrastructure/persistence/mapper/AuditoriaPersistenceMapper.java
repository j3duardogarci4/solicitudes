package cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper;

import cl.j3duardogarci4.solicitudes.domain.auditoria.Auditoria;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.AuditoriaEntity;

public interface AuditoriaPersistenceMapper {

    AuditoriaEntity toEntity(Auditoria auditoria);

    Auditoria toDomain(AuditoriaEntity entity);
}