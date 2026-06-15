Módulo Solicitud
-------------------
Entidades:
 - Solicitud
Servicios:
 - SolicitudService()
Depende de:
  - Usuario

Módulo Usuario
--------------
Entidades:
 - Usuario
Servicios:
  - UsuarioService()
Depende de:
 - Ninguno

Módulo Comentario
Entidades:
  - Comentario
Servicios:
  - ComentarioService()
Depende de:
  - Solicitud
  - Usuario

Módulo Auditoría
-----------------
Entidades:
   - Auditoria
Servicios:
   - AudiotriaService()
Depende de:
   - Usuario
   - Solicitud

Módulo Workflow
----------------
Entidades: Ninguna
Servicios:
 - WorkflowService()

Dependencias:
   - Solicitud
   - Comentario
   - Auditoría

Conclusión:
Solicitud es la entidad central del dominio.
Workflow es el principal orquestador del ciclo de vida de una Solicitud.
