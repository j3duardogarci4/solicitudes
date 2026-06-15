Módulo Solicitud
-----------------
-Entidades:
 -> Solicitud
 -Servicios:
 - SolicitudService()
-Depende de:
  - Usuario

Módulo Usuario
--------------
-Entidades:
 -> Usuario
-Servicios:
  - UsuarioService()
-Depende de:
 - Ninguno

Módulo Comentario
-----------------
-Entidades:
  - Comentario
-Servicios:
  - ComentarioService()
-Depende de:
  - Solicitud
  - Usuario

Módulo Auditoría
-----------------
-Entidades:
   - Auditoria
-Servicios:
   - AudiotriaService()
-Depende de:
   - Usuario
   - Solicitud

Módulo Workflow
----------------
-Entidades: Ninguna
-Servicios:
 - WorkflowService()
- Depende de:
   - Solicitud
   - Comentario
   - Auditoría

Conclusión:
Solicitud es la entidad central del dominio.
Workflow es el principal orquestador del ciclo de vida de una Solicitud.


Arquitectura lógica
===================
domain         -> reglas de negocio
application    -> casos de uso
infrastructure -> detalles técnicos

domain/
---------
solicitud/
usuario/
comentario/
workflow/
auditoria/

Responsabilidad:
Contener entidades, reglas de negocio, invariantes y servicios de dominio.

application/
--------------
Responsabilidad:
Orquestar casos de uso del sistema.

Ejemplos:
- CrearSolicitudUseCase
- AprobarSolicitudUseCase
- RechazarSolicitudUseCase

infrastructure/
----------------
Responsabilidad:
Resolver aspectos técnicos.

Ejemplos:
- Persistencia H2
- Repositorios
- Configuración Spring
- Seguridad
   

