Objetivo
Definir las responsabilidades principales del sistema y establecer la propiedad de los conceptos de negocio.

Módulo / Responsabilidad
Usuarios /	Gestión de usuarios, roles y privilegios.
Solicitudes /	Registro y consulta, modificaciòn de contenido, mantención de la información principal de una solicitud.
Workflow	/ Gestión de transiciones de estado, validación de reglas asociadas al flujo de aprobación.
Auditoría	/ Registro histórico de acciones realizadas sobre una solicitud. Mantención de trazabilidad del sistema.
Comentarios	/ Gestión de comentarios asociados a solicitudes.

Dependencias conceptuales
Workflow depende de Solicitudes.
Comentarios depende de Solicitudes.
+ Auditoría registra eventos producidos por los demás módulos.
+ Usuarios participa en todas las operaciones mediante autenticación y autorización.

Observaciones
EstadoSolicitud es un concepto central del dominio debido a que gran parte de las reglas de negocio se relacionan con las transiciones del flujo de aprobación.

Relaciones entre módulos

Módulo    	- Puede usar
Usuarios	  => Ninguno
Solicitudes => Usuarios
Workflow    => Solicitudes, Usuarios
Comentarios => Solicitudes, Usuarios
Auditoría	  => Solicitudes, Workflow, Comentarios

+ Workflow no modifica usuarios.
+ Auditoría no modifica solicitudes.
+ Comentarios no cambia estados.
+ Solicitudes no registra auditoría directamente.

