Entidades candidatas:
+ Usuario
+ Solicitud
+ Comentario
+ Auditoria

== Solicitud ==
id
fechaCreacion
descripcion
fechaActualizacion
creador
estadoSolicitud

* Reglas:
- Debe tener creador.
- Debe tener estado.
- No puede aprobarse a sí misma.
- No puede modificarse después de APROBADA.


== Usuario ==
id 
login
rol

{La autenticación será tratada como una preocupación de infraestructura.}

== Comentario ==
idComentario
solicitud
descComentario
fechaComentario

* Reglas:
- Debe pertenecer a una solicitud.
- Es obligatorio al rechazar.

== Auditoria ==
id
fechaRegistro
solicitud
accion
usuario

* Reglas:
- Debe registrar usuario.
- Debe registrar acción.
- No puede modificarse.

