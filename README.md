# Solicitudes

Aplicación backend para la gestión del ciclo de vida de solicitudes,
implementada utilizando DDD y Clean Architecture.

## Arquitectura

El proyecto separa las responsabilidades en las siguientes capas:

- **Domain**: entidades, reglas de negocio, repositorios y workflow.
- **Application**: casos de uso de la aplicación.
- **Infrastructure**: persistencia mediante Spring Data JPA y H2.
- **Presentation**: API REST y manejo de errores.

## Persistencia

- Spring Data JPA
- H2
- Repositorios desacoplados mediante interfaces de dominio.
- Adapters de persistencia.
- Mappers dominio ↔ persistencia.

## Workflow

El ciclo de vida de una solicitud contempla:

```text
BORRADOR
   ↓
ENVIADA
   ↓
EN_REVISION
   ├── APROBADA
   └── RECHAZADA


   Las transiciones son gestionadas por WorkflowService.

## Auditoría

Las acciones relevantes del workflow son registradas mediante
AuditoriaService.

Actualmente se encuentra validado el registro de:

Envío de solicitud.
Inicio de revisión.
Aprobación.
Rechazo.
Comentarios

Los rechazos requieren un comentario obligatorio.

El comentario registra:

Descripción.
Fecha de registro.
Solicitud asociada.
Supervisor que registra el rechazo.
API REST

## Endpoints actualmente disponibles:

POST   /solicitudes
GET    /solicitudes/{id}
PUT    /solicitudes/{id}
PUT    /solicitudes/{id}/enviar
PUT    /solicitudes/{id}/iniciar-revision
PUT    /solicitudes/{id}/aprobar
PUT    /solicitudes/{id}/rechazar
Estado actual
Dominio implementado.
Clean Architecture.
Casos de uso implementados.
Workflow implementado y validado.
Repositorios desacoplados mediante interfaces.
Persistencia con Spring Data JPA.
Base de datos H2.
Mappers dominio ↔ persistencia.
Auditoría de acciones del workflow.
Comentarios asociados a rechazos.
Pruebas funcionales de las principales transiciones del workflow.
Ejecución

Para iniciar la aplicación:

mvn spring-boot:run