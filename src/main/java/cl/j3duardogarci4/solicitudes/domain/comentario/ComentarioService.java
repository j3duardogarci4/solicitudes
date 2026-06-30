package cl.j3duardogarci4.solicitudes.domain.comentario;

import java.util.List;
import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;

   public class ComentarioService {
      
    private final ComentarioRepository comentarioRepository;
    private final AuditoriaService auditoriaService;
    
      public ComentarioService(
         ComentarioRepository comentarioRepository, 
         AuditoriaService auditoriaService) {
       
         this.auditoriaService = auditoriaService;
         this.comentarioRepository = comentarioRepository;
    }   
    public void registrarComentario(Comentario comentario) {

    }

    public  List<Comentario> obtenerComentarios(Long idSolicitud) {
        return List.of();
    }

}
