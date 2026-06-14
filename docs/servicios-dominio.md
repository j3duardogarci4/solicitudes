Agrupación de operaciones del negocio:

  * SolicitudService
  -------------------
   -> crearSolicitud()
   -> modificarSolicitud()
   -> enviarSolicitud()
   -> crearSolicituDesdeRechazada()

  * UsuariosService
  ------------------
   -> crearUsuario()
   -> asignarPerfil() 
   -> deshabilitarUsuario()

  * WorkflowService
  ------------------
    -> iniciarRevision()
    -> aprobarSolicitud()
    -> rechazarSolicitud()
    -> cerrarSolicitud()
    -> eliminarSolicitud()

  * ComentariosService
  ---------------------
   -> registrarComentario()
   -> obtenerComentario()

  * AuditoriaService
  -------------------
   -> registraAccion()
   -> consultarHistorial()

  * SolicitudService
  -------------------
Operacion: crearSolicitud()
Entradas:
  - Usuario creador
  - Descripcion
  
Validaciones:
  - Usuario válido
  - Usuario activo
  - Descripción obligatoria
  - Descripción cumple longitud mínima.

Resultado:
  - Generación de Id de solicitud único.
  - Registro de fecha de creación.
  - Asociacion al usuario creador.
  - Asignación de estado BORRADOR 

Operación: modificarSolicitud()
Entradas:
    - Id de solicitud
    - Usuario creador
    - Nueva descripción

Validaciones:
    - La solicitud existe
    - Usuario creador válido
    - Estado de solicitud en BORRADOR
    - La nueva descripción cumple los requisitos mínimos definidos
Resultado:
    - Descripción actualizada
    - Fecha de actulización registrada

Operación: enviarSolicitud()
Entradas: 
    - Id solicitud
    - Usuario creador
Validaciones:
    - La solicitud existe.
    - El usuario corresponde al creador de la solicitud
    - El estado actual es BORRADOR
    - La solicitud contiene la información mínima requerida
    - La solicitud no se encuentra eliminada

Resultado:
    - Registro de auditoria
    - Estado actual ENVIADA


Operación: crearSolicitudDesdeRechazada()

Entradas:
    - Id solicitud rechazada
    - Usuario creador

Validaciones:
    - Solicitud rechazada existente.
    - El usuario corresponde al creador de la solicitud rechazada.
    - El estado actual es RECHAZADA o CERRADA derivada de rechazo.

Resultado:
    - Nueva solicitud creada.
    - Copia de la información de la solicitud rechazada.
    - Generación de nuevo identificador.
    - Registro de fecha de creación.
    - Estado inicial BORRADOR.


  * WorkflowService
  ------------------
Operación: iniciarRevision()
Entradas:
   - Id de solicitud
   - Supervisor

Validaciones:
    - Estado de solicitud  ENVIADA
    - Supervisor válido.
Resultado:
    - Cambio de estado de solicitud a EN_REVISION
    - Supervisor asignado a la solicitud
    - Registro de auditoria

Operación: aprobarSolicitud()
Entradas:
    - Id solicitud
    - Supervisor
Validaciones:
    - Solicitud no expirada
    - Estado actual EN_REVISION
    - Supervisor asignado
    - Supervisor distinto del creador
Resultado:
    - Estado APROBADA
    - Registro de auditoría 

Operación: aprobarSolicitud()
Entradas:
   - Id de solicitud
   - Usuario supervisor

Validaciones:
    - Solicitud existente
    - Supervisor asignado es válido
    - Solicitud no expirada
    - Estado de solicitud registrado como ENVIADA
    - Supervisor no es el mismo usuario creador.
Resultado:
    - Cambio de estado de solicitud a APROBADA
    - Registro de auditoria

Operación: rechazarSolicitud()
Entradas:
    - Id solicitud
    - Supervisor
    - Comentario 

Validaciones:
    - Estado actual EN_REVISION
    - Comentario válido
    - Supervisor asignado
    - Supervisor distinto de creador

Resultado
    - Registro de auditoria
    - Estado RECHAZADA
    - Registro de comentario

Operación: cerrarSolicitud()
Entradas: 
    - Id solicitud
    - Usuario creador
Validaciones:
    - El usuario corresponde al creador de la solicitud
    - El estado actual es RECHAZADA o APROBADA
Resultado:
    - Registro de auditoria
    - Estado actual CERRADA

Operación: eliminarSolicitud()
Entradas: 
    - Id solicitud
    - Usuario creador
Validaciones:
    - El usuario corresponde al creador de la solicitud
    - El estado actual es BORRADOR o ENVIADA

Resultado
    - Registro de auditoria
    - Estado actual ELIMINADA


* UsuarioService
-----------------

Operación: crearUsuario()  
Entradas:
     - Login de usuario
     - Identificación mínima
Validaciones:
     - Usuario NO creado previamente
     - Información mínima requerida completa.
     - Login obligatorio
Resultado:
     - Usuario registrado
     - Perfil de lectura asignado por defecto.
     - Registro de auditoria

Operación: asignarPerfilUsuario()
Entradas:
     - Login de usuario
     - Perfil requerido
Validaciones:
     - Usuario existente
     - Usuario activo
     - Perfil requerido válido
Resultado:
     - Usuario con perfil asignado.

Operación: dehabilitarUsuario()
Entradas:
     - Login de usuario
     - Motivo desactivación
Validaciones:
     - Usuario previamente registrado
     - Usuario activo
     - Motivo de desactivación cumple longitud mínima.

Resultado:
     - Usuario desactvidado. 





* ComentariosService
  ---------------------
Operación: registrarComentario()
Entradas:
     - Id de solicitud
     - Comentario
     - Supervisor
Validaciones:
    - Solicitud existente.
    - Supervisor válido.
    - Estado actual EN_REVISION.
    - Comentario cumple longitud mínima.
Resultado:
     - Comentario registrado


Operación: obtenerComentario()
Entradas:
     - Identificador de solicitud
     - usuario autorizado

Validaciones:
     - Usuario que solicita es creador o perfil supervisor
     - estado de solicitud corresponde a RECHAZADO
Resultado:
     - Lista de comentarios asociados a la solicitud.



Operación: consultarHistorial()
Entradas:
      - Rango de consulta
Validaciones:

Resultado:
      - Listado de comentarios solicitados.


* Auditoría Service
--------------------
Operación: registrarAccion()
Entradas:
    - Usuario
    - Id solicitud
    - Acción

Validaciones:
    - Usuario válido.
    - Solicitud existente.
    - Acción válida.

Resultado:
    - Registro de auditoría generado.

Observaciones
-------------
La mayoría de las operaciones de Workflow corresponden a cambios de estado de una Solicitud. Todas las transiciones válidas deben registrar auditoría y respetar las reglas definidas por el Workflow.



