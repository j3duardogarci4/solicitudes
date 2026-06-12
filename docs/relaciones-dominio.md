 Usuario
   |
   | crea
   v 
 Solicitud
   |
   +------> EstadoSolicitud
   |
   +------> Comentario
   |
   +------> Auditoria

Cardinalidades:
 1 Solicitud -> 1 Usuario Creador
 1 Solicitud -> N Comentarios
 1 Usuario   -> N Solicitudes
 1 Solicitud -> N Auditorias
 1 Solicitud -> 1 EstadoSolicitud
 1 Usuario   -> N Solicitudes

Observaciones:
 [-] Una solicitud pasa por varios estados a lo largo de su ciclo de vida
 [-] El historial de cambios de estado queda registrado mediante Auditoría.
 [-] Comentarios y Auditoría dependen de la existencia de una Solicitud.

Conclusiones:
 + Solicitud es la entidad principal del dominio
 + Toda Auditoria pertenece a una solicitud
 + Todo Comentario pertenece a una solicitud
 + Toda Solicitud posee un Estado actual
 + Toda Solicitud tiene un Usuario creador

