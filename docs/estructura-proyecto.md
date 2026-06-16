Directorios:
------------
```text
src/main/java
  cl/j3duardogarci4/solicitudes

   -> domain
	    -> solicitud
	    	-> SolicitudService.java
	    	  + Implementa las operaciones de creación, modificación y envío de solicitudes.
	    	-> Solicitud.java
	    	  + Representa una solicitud
	    	-> SolicitudRepository.java
	    	  + Define las operaciones necesarias para almacenar y recuperar solicitudes.
	    -> comentario
	        -> Comentario.java
	          + Representa un comentario asociado a una solicitud.
	        -> ComentarioService.java
	           + Implementa las operaciones del negocio sobre la entidad comentario.
	        -> ComentarioRepository.java
	        	+ Define las operaciones necesarias para almacenar y recuperar comentarios de una solicitud.
	    -> usuario
	        -> Usuario.java
	           + Representa una cuenta de usuario del sistema.
	        -> UsuarioService.java
	           + Implementa las operaciones de administración de usuarios del sistema.
	        -> UsuarioRepository.java
	           + Define las operaciones necesarias para almacenar y recuperar atributos de una cuenta de usuario

	    -> auditoria
	        -> Auditoria.java
	          + Representa un registro de auditoria de una solicitud
	        -> AuditoriaService.java
	          + Implementa las operaciones de registro y consulta de auditoría.
	        -> AuditoriaRepository.java
	          + Define las operaciones necesarias para almacenar y recuperar un registro de auditoria
	    -> workflow
	        -> WorkflowService.java 
	       	  + Implementa las reglas de transición de estados y ciclo de vida de una solicitud.
   -> application
      + Contiene los casos de uso del sistema.

   -> infrastructure
      + Contiene la implementación de persistencia,
     configuración e integraciones técnicas.
  
