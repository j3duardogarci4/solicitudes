package cl.j3duardogarci4.solicitudes.domain.comentario;

import java.util.List;

public interface ComentarioRepository {

    void guardar(Comentario comentario);

    List<Comentario> buscarPorSolicitud(Long idSolicitud);

}