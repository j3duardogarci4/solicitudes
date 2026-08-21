package cl.j3duardogarci4.solicitudes.infrastructure.persistence.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
import cl.j3duardogarci4.solicitudes.domain.comentario.ComentarioRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.ComentarioEntity;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper.ComentarioPersistenceMapper;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository.ComentarioJpaRepository;

@Repository
public class ComentarioRepositoryAdapter implements ComentarioRepository {

    private final ComentarioJpaRepository comentarioJpaRepository;
    private final ComentarioPersistenceMapper comentarioPersistenceMapper;

    public ComentarioRepositoryAdapter(
            ComentarioJpaRepository comentarioJpaRepository,
            ComentarioPersistenceMapper comentarioPersistenceMapper) {

        this.comentarioJpaRepository = comentarioJpaRepository;
        this.comentarioPersistenceMapper = comentarioPersistenceMapper;
    }

    @Override
    public void guardar(Comentario comentario) {

        ComentarioEntity entity =
                comentarioPersistenceMapper.toEntity(comentario);

        comentarioJpaRepository.save(entity);
    }

    @Override
    public List<Comentario> buscarPorSolicitud(Long idSolicitud) {

        return comentarioJpaRepository
                .findByIdSolicitud(idSolicitud)
                .stream()
                .map(comentarioPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }
}