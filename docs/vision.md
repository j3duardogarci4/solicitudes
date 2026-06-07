"Necesitamos un sistema para gestionar solicitudes internas."

Que ocurre hoy:
Actualmente las solicitudes internas son gestionadas mediante correos electrónicos y comunicación informal, lo que dificulta la trazabilidad, el seguimiento y la auditoría de los procesos.

Paso 2 --> Definir objetivo

Que problema se resuelve?
-Las empresas necesitan gestionar solicitudes internas de manera centralizada, manteniendo trazabilidad, auditoría y estados de aprobación.
El sistema permitirá crear, gestionar y aprobar solicitudes internas, manteniendo historial, estados y auditoría completa de cada operación.

Quienes usaran el sistema?
- Empleados:
    Crean solicitudes en el sistema.
    Consultan el estado de las solicitudes.
    Ven el historial de solicitudes registradas.

- Supervisores
    Revisa solicitudes
    Cambia de estado las solicitudes (Aprueba/Rechaza)

- Administradores
    Gestionan usuarios
    Consulta auditoria
    Configura parámetros del sistema

Historias de usuario:
    Empleado: Poder registrar solicitudes, poder dejarlas en borrador y luego enviarlas a aprobación. Tener la posibilidad de consultar las solicitudes y recibir notificaciones cuando cambian de estado.
    
    Supervisor: Poder revisar las solicitudes registradas para poder aprobar o rechazar conforme a los parámetros definidos teniendo la posibilidad de registrar comentarios asociados al cambio de estado.

    Adminsitrador: Poder gestionar permisos de usuarios, crear cuentas y revisar los registros de auditoria de las operaciones registradas en el sistema.

Fuera de Alcance Versión 1.0
- Firma electrónica
- Aplicación móvil
- Integraciones con otros sistemas
- Workflow configurable

Conceptos de negocio
1) Solicitud
2) Usuario del sistema (Empleado-Supervisor-Administrador)
3) Historial de cambios (Auditoria)
4) Comentarios 
5) Periodo de vigencia de solicitudes
6) Estado de solicitud

Preguntas abiertas:
1) Una solicitud no puede ser aprobada por un mismo usuario?
2) Solo los estados de rechazo exigen comentarios
3) Una solicitud rechazada no puede volver al flujo ?
4) Si una solicitud no se aprueba o rechaza se cierra despues de un periodo?
5) El flujo de estado es en una sola dirección?
- ¿Múltiples aprobadores?
- ¿Flujos distintos por tipo?