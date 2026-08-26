# Estructura del proyecto

## Directorios

```text
src/main/java

cl/j3duardogarci4/solicitudes

├── application
│   └── solicitud
│       ├── ActualizarSolicitudUseCase.java
│       ├── AprobarSolicitudUseCase.java
│       ├── BuscarSolicitudUseCase.java
│       ├── CerrarSolicitudUseCase.java
│       ├── CrearSolicitudUseCase.java
│       ├── EnviarSolicitudUseCase.java
│       ├── IniciarRevisionUseCase.java
│       └── RechazarSolicitudUseCase.java
│
├── domain
│   ├── solicitud
│   │   ├── Solicitud.java
│   │   │   + Representa una solicitud.
│   │   ├── SolicitudRepository.java
│   │   │   + Define las operaciones necesarias para almacenar y recuperar solicitudes.
│   │   └── SolicitudService.java
│   │       + Contiene operaciones de negocio asociadas a la solicitud.
│   │
│   ├── comentario
│   │   ├── Comentario.java
│   │   │   + Representa un comentario asociado a una solicitud.
│   │   └── ComentarioRepository.java
│   │       + Define las operaciones necesarias para almacenar y recuperar comentarios.
│   │
│   ├── usuario
│   │   ├── Usuario.java
│   │   │   + Representa una cuenta de usuario del sistema.
│   │   ├── UsuarioService.java
│   │   │   + Contiene operaciones de administración de usuarios.
│   │   └── UsuarioRepository.java
│   │       + Define las operaciones necesarias para almacenar y recuperar usuarios.
│   │
│   ├── auditoria
│   │   ├── Auditoria.java
│   │   │   + Representa un registro de auditoría de una solicitud.
│   │   ├── AuditoriaService.java
│   │   │   + Registra las acciones realizadas sobre las solicitudes.
│   │   └── AuditoriaRepository.java
│   │       + Define las operaciones necesarias para almacenar y recuperar registros de auditoría.
│   │
│   └── workflow
│       └── WorkflowService.java
│           + Implementa las reglas de transición de estados y ciclo de vida de una solicitud.
│
├── infrastructure
│   ├── config
│   │   + Contiene configuración técnica de la aplicación.
│   │
│   └── persistence
│       ├── adapter
│       │   + Implementa los contratos de persistencia definidos por el dominio.
│       ├── entity
│       │   + Contiene las entidades JPA utilizadas para persistencia.
│       ├── mapper
│       │   + Realiza la conversión entre objetos de dominio y entidades de persistencia.
│       └── repository
│           + Contiene los repositorios Spring Data JPA.
│
└── presentation
    ├── error
    │   + Contiene el manejo global de errores y respuestas de validación.
    │
    └── solicitud
        ├── SolicitudController.java
        │   + Expone los endpoints REST relacionados con solicitudes.
        │
        └── dto
            ├── CrearSolicitudRequest.java
            └── RechazarSolicitudRequest.java