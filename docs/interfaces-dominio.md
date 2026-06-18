[Definición de interfaces y contratos del dominio]

Interface: SolicitudRepository
* Responsabilidad: 
  Persistir y recuperar solicitudes.
* Operaciones:
++ guardar()
+ actualizar()
+ buscarPorId()

Interface: UsuarioRepository
Responsabilidad:
 -> Persistir y recuperar datos de usuario
Operaciones:
+ guardar()
+ actualizar()
+ buscarPorId()
+ buscarPorLogin()
  
Interface: ComentarioRepository
Responsabilidad:
-> Persistir y recuperar comentarios de una solicitud.
Operaciones:
+ guardar()
+ buscarPorSolicitud()
+ buscarPorId()
  
Interface: AuditoriaRepository
Responsabilidad
 -> Persistir y recuperar registros de auditoria
Operaciones:
+  guardar()
+  buscarPorSolicitud()
+  buscarPorRangoFecha()
  
