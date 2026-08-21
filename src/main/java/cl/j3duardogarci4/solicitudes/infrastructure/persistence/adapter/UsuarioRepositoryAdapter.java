package cl.j3duardogarci4.solicitudes.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import cl.j3duardogarci4.solicitudes.domain.usuario.UsuarioRepository;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.entity.UsuarioEntity;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.mapper.UsuarioPersistenceMapper;
import cl.j3duardogarci4.solicitudes.infrastructure.persistence.repository.UsuarioJpaRepository;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioPersistenceMapper usuarioPersistenceMapper;

    public UsuarioRepositoryAdapter(
            UsuarioJpaRepository usuarioJpaRepository,
            UsuarioPersistenceMapper usuarioPersistenceMapper) {

        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioPersistenceMapper = usuarioPersistenceMapper;
    }

    @Override
    public void guardar(Usuario usuario) {

        UsuarioEntity entity =
                usuarioPersistenceMapper.toEntity(usuario);

        usuarioJpaRepository.save(entity);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {

        return usuarioJpaRepository
                .findById(id)
                .map(usuarioPersistenceMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorLogin(String login) {

        return usuarioJpaRepository
                .findByLogin(login)
                .map(usuarioPersistenceMapper::toDomain);
    }

    @Override
    public void actualizar(Usuario usuario) {

        UsuarioEntity entity =
                usuarioPersistenceMapper.toEntity(usuario);

        usuarioJpaRepository.save(entity);
    }
}