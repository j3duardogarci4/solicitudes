CU-01 Crear solicitud.
Actor => Empleado
Flujo:
1.- Ingresar descripción
2.- Presionar Crear
3.- Sistema valida
4.- Sistema registra
5.- Estado = Borrador

CU-01-A  Enviar solicitud
1.- Seleccionar solicitud en estado borrador
2.- Presionar enviar a revision
3.- Sistema valida
4.- Estado = ENVIADA

CU-02 Consultar Solicitud
Actores => Empleado / Supervisor / Administrador
Flujo:
1.- Buscar solicitud
2.- Sistema entrega detalle de solicitud

CU-03 Aprobar solicitud
Actor => Supervisor
Precondiciones:
- La solicitud existe.
- La solicitud se encuentra en estado EN_REVISION.
- El supervisor tiene permisos para aprobar.
Flujo:
1.- El sistema muestra al supervisor las solicitudes pendientes de revisión.
2.- El supervisor selecciona una solicitud.
3.- El sistema muestra el detalle de la solicitud.
4.- El supervisor aprueba la solicitud.
5.- El sistema valida las reglas de negocio.
6.- El sistema registra la aprobación.
7.- El sistema registra auditoría.
8.- El sistema cambia el estado a APROBADA.
9.- El sistema confirma la operación.
Postcondiciones:
+ La solicitud queda en estado APROBADA.
+ Existe un registro de auditoría asociado.

CU-04 Rechazar solicitud
Actor => Supervisor
Flujo:
1. Revisa solicitud.
2. Ingresa comentario obligatorio.
3. Rechaza.
4. Sistema registra auditoría.
5. Estado = RECHAZADA.

CU-05 Consultar Auditoría
Actor => Administrador
Flujo:
1. Selecciona solicitud.
2. Sistema muestra historial.

