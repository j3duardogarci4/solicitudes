1 ) Operaciones que puede realizar una:
---------------------------------------

Solicitud
---------

 -> crear()
 -> modificar()
 -> cambiardeEstado()
 
  Posibles estados de una solicitud:
- BORRADOR
- ENVIADA
- EN_REVISION
- APROBADA
- RECHAZADA
- CERRADA
- ELIMINADA


Comentario
----------
Solo se registra para solicitudes en estado RECHAZADA

Auditoria
---------
Se registra por cada cambio de estado realizado a la solicitud posterior a enviada. (Borradores no se auditan).
Registrar que ocurrió.
No decide.
No valida.
Solo registra.
Las operaciones relevantes sobre una Solicitud se expresan principalmente mediante transiciones de estado.

2 ) Workflow
---------------
Posibles transiciones.
Solicitud se crea en estado -> BORRADOR
BORRADOR    -> ENVIADA       
BORRADOR    -> ELIMINADA

ENVIADA     -> EN_REVISION

EN_REVISION -> APROBADA
            -> RECHAZADA

RECHAZADA   -> CERRADA
APROBADA    -> CERRADA

CERRADA Y ELIMINADA son estados finales, una solicitud rechazada no puede corregirse, se debe abrir una solicitud nueva. Pudiendo utilizar los datos de una solicitud con estado rechazado para su creación.
RECHAZADA no es un estado terminal.

Una solicitud rechazada debe ser cerrada por el creador de la solicitud,
quien toma conocimiento del rechazo y de los comentarios asociados.

Alternativamente, un proceso automático de expiración puede realizar el
cierre cuando el creador no ha tomado conocimiento dentro del plazo definido.

Reglas por transición
---------------------
* BORRADOR    -> ENVIADA     => Solo puede ser actualizada a este estado por el creador de la solicitud
                                La solicitud debe contener la información mínima requerida.
  
* BORRADOR    -> ELIMINADA   => Solo puede ser actualizada a este estado por el creador de la solicitud
* ENVIADA     -> EN_REVISION => Solo el perfil de Supervisor puede actualizar este estado.
* EN_REVISION -> APROBADA    => Solo el perfil de Supervisor puede actualizar este estado.
                                El supervisor aprobador no puede ser el creador de la solicitud.
  
* EN_REVISION -> RECHAZADA   => Solo el perfil de Supervisor puede actualizar este estado y mandatoriamente debe dejar un comentario.
* RECHAZADA   -> CERRADA     => Solo puede ser actualizada a este estado por el creador de la solicitud o por el proceso de expiración que marca dicho comentario
* APROBADA    -> CERRADA     => Solo puede ser actualizada a este estado por el creador de la solicitud o por el proceso de expiración que marca dicho comentario
 
Responsabilidades
-----------------
Modulo: Solicitud 
Responsable de: 
   - Crear solicitud
   - Editar solicitud
   - Asociar solicitud a su creador
   - Mantener el estado actual de la solicitud
   - Validar el registro de información mínima requerida.
No es responsable de:
  - Validar transiciones de estado.
  - Validar expiración.
  - Registrar auditoría.
         
Módulo Workflow
Responsable de:
    - Validar transiciones entre estados.
    - Validar permisos para cambios de estado.
    - Validar expiración.
    - Determinar estados terminales.
No es responsable de:
    - Mantener datos de la solicitud.
    - Registrar auditoría.
 
Comentarios
Responsable de:
     - Registrar comentarios asociados a solicitudes.
     - Validar obligatoriedad de comentarios en rechazos.
No es responsable de:
     - Cambiar estados.
     - Aprobar solicitudes
 
Auditoria
Responsable de:
     - Registrar cambios de estado.
     - Registrar acciones realizadas por usuarios.
     - Mantener trazabilidad del sistema.
Información mínima registrada:
- Login usuario.
- Fecha y hora.
- Identificador de solicitud.
- Acción ejecutada.
No es responsable de:
     - Restringir acceso
     - Validar datos contenidos en la solicitud
     
Usuarios
Reponsable de:
   - Gestionar usuarios.
   - Gestionar perfiles.
   - Validar perfiles válidos.
No es responsable de:
   - Gestionar solicitudes.
   - Gestionar workflow.
 

Invariantes
-----------
Solicitud
 + Una solicitud tiene un solo creador
 + Debe ser revisada por un solo supervisor
 + Debe tener un estado actual
 + Debe tener una fecha de creación
 + Si se encuentra en estado cerrado no se puede cambiar a estados anteriores.
 + Solicitud APROBADA no admite modificación.
 + Una solicitud ELIMINADA no admite modificación.
   
Comentario
 + Todo comentario pertenece a una única solicitud.
 + Toda solicitud RECHAZADA posee al menos un comentario asociado.
 + Debe contener una extensión mínima definida.
 + Solo debe ser registrado por un usuario con perfil Supervisor
 + Todo comentario debe tener fecha de registro.
 + Un rechazo siempre debe poseer al menos un comentario asociado.
    
Auditoria
  + Todo registro de auditoría debe registrar:
   - Usuario
   - Fecha y hora
   - Solicitud asociada
   - Acción ejecutada
  + Un registro de auditoria nunca puede ser modificado.
    
Usuario
  + Debe tene un perfil asociado
  + Debe estar activo para operar en el sistema
  + El login de usuario debe ser único.
    
Workflow
  + Toda solicitud posee un único estado actual.
  + Solo se permiten transiciones definidas en el workflow.
  + Los estados CERRADA y ELIMINADA son terminales.
  + Un usuario no puede aprobar una solicitud creada por él mismo.
  + Toda solicitud RECHAZADA debe poseer al menos un comentario asociado.

   
## Estado de implementación

Las reglas definidas en este documento representan el comportamiento esperado
del dominio.

A la fecha, se encuentran implementadas y validadas:

- BORRADOR → ENVIADA
- ENVIADA → EN_REVISION
- EN_REVISION → APROBADA
- EN_REVISION → RECHAZADA
- Registro de auditoría asociado a las transiciones.
- Registro obligatorio de comentario en rechazo.
- Persistencia de comentario con solicitud, supervisor y fecha.

Pendientes de implementación:

- Validación de que el supervisor aprobador no sea el creador.
- RECHAZADA → CERRADA mediante creador.
- APROBADA → CERRADA mediante creador.
- Proceso automático de expiración.
- BORRADOR → ELIMINADA mediante endpoint/caso de uso.
