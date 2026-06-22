Interface: SolicitudRepository
------------------------------
### Responsabilidad
      Persistir y recuperar solicitudes.
### Método
      guardar()
### Parámetros
      Solicitud
### Retorno
      Ninguno
### Método
      buscarPorId()
### Parámetros
      Long id
### Retorno
      Solicitud

### Método
      actualizar()
### Parámetros
      Solicitud
### Retorno
      Ninguno

Interface: UsuarioRepository
----------------------------
### Responsabilidad
      Persistir y recuperar usuarios.
### Métodos
      guardar()
### Parámetros
      Usuario
      
### Retorno
      Ninguno

### Método 
      buscarPorId()
### Parámetros
      Long Id
### Retorno
      Usuario

### Método
      buscarPorLogin()
### Parámetros
      String login
### Retorno
      Usuario

### Método
      actualizar()
### Parámetros
      Usuario
### Retorno
      Ninguno

Interface: ComentarioRepository
-------------------------------
### Responsabilidad
      Persistir y recuperar comentarios.
### Métodos
      guardar()
### Parámetros
      Comentario
### Retorno
      Ninguno

buscarPorSolicitud()
### Parámetros
      Long idSolicitud
### Retorno
      Lista de Comentarios

Interface : AuditoriaRepository
-------------------------------
### Responsabilidad
      Persistir y recuperar registros de auditoría.
### Método
      guardar()
### Parámetros
      Auditoria
### Retorno
      Ninguno

### Método 
      buscarPorSolicitud()
### Parámetros
      Long idSolicitud
### Retorno
      Lista de Auditorias

### Método
      buscarPorRangoFechas()
### Parámetros
      Fecha inicio
      Fecha fin
### Retorno
      Lista de Auditorias

