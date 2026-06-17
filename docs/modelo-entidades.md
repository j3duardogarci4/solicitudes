''text
*Solicitud*
id
descripción
fecha_generacion
fecha_actualizacion
estado
idUsuarioCreador
idSupervisorAsignado

*Usuario*
id
login
perfil
fecha_registro
activo

*Comentario*
id
comentario
idsolicitud
idSupervisor
fecha

*Auditoria*
id
fecha
idsolicitud
idUsuario
accion

Relaciones
-----------
Solicitud 1 -> N Comentarios
Solicitud 1 -> N Auditorias
Usuario 1 -> N Solicitudes
Usuario 1 -> N Comentarios
Usuario 1 -> N Auditorias

Observaciones
-------------
Las entidades mantienen referencias mediante identificadores
(idUsuario, idSolicitud, idSupervisor) para reducir el acoplamiento
entre módulos en las primeras iteraciones del diseño.





