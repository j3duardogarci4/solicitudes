package cl.j3duardogarci4.solicitudes.domain.comentario;

   public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final AuditoriaService auditoriaService;
    public void ComentarioService(ComentarioRepository comentarioRepository, AuditoriaService auditoriaService){
       this.auditoriaService = auditoriaService;
       this.comentarioRepository = comentarioRepository;
    }   
    public void registrarComentario(Comentario comentario) {

    }

    public void obtenerComentarios(Long idSolicitud) {

    }

}
