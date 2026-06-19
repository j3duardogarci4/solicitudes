## Entidad: Solicitud
### Atributos:
- Long id
- LocalDateTime fechaRegistro
- LocalDateTime fechaActualizacion
- String descripcion
- EstadoSolicitud estado
- Long idUsuarioCreador
- Long idSupervisorAsignado
  
## Entidad: Usuario
### Atributos:
- Long id
- String login
- LocalDateTime fechaCreacion
- perfilUsuario perfil
- LocalDateTime fechaActualizacion
- Boolean activo

## Entidad: Comentario
### Atributos
- Long id
- String descripcion
- LocalDateTime fechaRegistro
- Long idSolicitud
- Long idSupervisor


## Entidad Auditoria
### Atributos
- Long id
- Long idSolicitud
- Long idUsuario
- String accion
- LocalDateTime fechaRegistro

## EstadoSolicitud (enum)
 - BORRADOR
 - ENVIADA
 - EN_REVISION
 - RECHAZADA
 - APROBADA
 - CERRADA
 - ELIMINADA
## PerfilUsuario (enum)
- Lector
- Supervisor
- Administrador


