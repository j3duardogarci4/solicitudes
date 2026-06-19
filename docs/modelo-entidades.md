
# Solicitud
---------
- id
- descripción
- fecha_generacion
- fecha_actualizacion
- estado
- idUsuarioCreador
- idSupervisorAsignado
## Relaciones
- Una Solicitud posee un Usuario creador.
- Una Solicitud posee un Supervisor asignado.
- Una Solicitud puede tener múltiples Comentarios.
- Una Solicitud puede tener múltiples registros de Auditoría.

## Invariantes
- Toda solicitud debe tener un identificador único.
- Toda solicitud debe tener un usuario creador.
- Toda solicitud debe tener una descripción.
- Toda solicitud debe tener fecha de creación.
- Toda solicitud debe tener un estado actual.
- Una solicitud ELIMINADA no puede ser modificada.
- Una solicitud CERRADA no puede volver a estados anteriores.
- Una solicitud APROBADA no puede ser modificada.

### Observaciones
El supervisor asignado es opcional mientras la solicitud se encuentre en estado BORRADOR o ENVIADA.
Una solicitud en estado EN_REVISION debe tener un supervisor asignado.
La eliminación de solicitudes corresponde a un cambio de estado (ELIMINADA) y no a una eliminación física del registro.

Usuario
-------
- id
- login
- perfil
- fecha_registro
- activo

## Relaciones
- Un usuario puede crear 1 a N solicitudes
- Un usuario debe tener un único perfil

## Invariantes
- El login de usuario debe ser único
- Todo usuario debe tener un perfil asignado
- La creación del usuario debe tener una fecha de registro

Comentario
----------
- id
- comentario
- idsolicitud
- idSupervisor
- fecha
## Relaciones
- Un comentario pertenece a una única solicitud
  
## Invariantes
- Todo comentario debe contener texto.
- Todo comentario debe estar asociado a una solicitud.
- Todo comentario debe estar asociado a un supervisor.
- Todo comentario debe tener fecha de registro.

Auditoria
----------
- id
- fecha
- idsolicitud
- idUsuario
- accion
## Relaciones
- Un registro de auditoría pertenece a una única solicitud.
- Un registro de auditoría es generado por un único usuario.
  
## Invariantes
- Todo registro de auditoria debe estar asociado a una solicitud
- Todo registro de auditoria debe tener una fecha de registro
- Un registro de auditoría no puede ser modificado una vez creado.
- Todo registro de auditoría debe estar asociado a un usuario.
- Todo registro de auditoría debe tener una acción.

Relaciones
-----------
- Solicitud 1 -> N Comentarios
- Solicitud 1 -> N Auditorias
- Usuario 1 -> N Solicitudes
- Usuario 1 -> N Comentarios
- Usuario 1 -> N Auditorias

Observaciones
-------------
Las entidades mantienen referencias mediante identificadores
(idUsuario, idSolicitud, idSupervisor) para reducir el acoplamiento
entre módulos en las primeras iteraciones del diseño.







