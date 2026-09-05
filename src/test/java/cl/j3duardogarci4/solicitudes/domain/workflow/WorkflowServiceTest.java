package cl.j3duardogarci4.solicitudes.domain.workflow;

import cl.j3duardogarci4.solicitudes.domain.auditoria.AuditoriaService;
import cl.j3duardogarci4.solicitudes.domain.comentario.ComentarioRepository;
import cl.j3duardogarci4.solicitudes.domain.solicitud.EstadoSolicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;
import cl.j3duardogarci4.solicitudes.domain.usuario.PerfilUsuario;
import cl.j3duardogarci4.solicitudes.domain.usuario.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class WorkflowServiceTest {

    @Test
    void noDebePermitirQueCreadorApruebeSuPropiaSolicitud() {

        SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
        ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
        AuditoriaService auditoriaService = mock(AuditoriaService.class);

        WorkflowService workflowService = new WorkflowService(
                solicitudRepository,
                comentarioRepository,
                auditoriaService
        );

        Usuario supervisor = new Usuario();
        supervisor.setId(1L);
        supervisor.setPerfil(PerfilUsuario.SUPERVISOR);
        supervisor.setActivo(true);

        Solicitud solicitud = new Solicitud();
        solicitud.setId(10L);
        solicitud.setIdUsuarioCreador(1L);
        solicitud.setEstado(EstadoSolicitud.EN_REVISION);

        assertThrows(
                IllegalArgumentException.class,
                () -> workflowService.aprobarSolicitud(
                        solicitud,
                        supervisor
                )
        );

        verify(solicitudRepository, never()).actualizar(solicitud);

        verify(auditoriaService, never()).registrarAccion(
                solicitud.getId(),
                "SOLICITUD_APROBADA",
                supervisor
        );
    }

    @Test
void noDebePermitirQueOtroUsuarioCierreLaSolicitud() {

    SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
    ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
    AuditoriaService auditoriaService = mock(AuditoriaService.class);

    WorkflowService workflowService = new WorkflowService(
            solicitudRepository,
            comentarioRepository,
            auditoriaService
    );

    Usuario creador = new Usuario();
    creador.setId(1L);

    Usuario otroUsuario = new Usuario();
    otroUsuario.setId(2L);
    otroUsuario.setActivo(true);

    Solicitud solicitud = new Solicitud();
    solicitud.setId(10L);
    solicitud.setIdUsuarioCreador(creador.getId());
    solicitud.setEstado(EstadoSolicitud.APROBADA);

    assertThrows(
            IllegalArgumentException.class,
            () -> workflowService.cerrarSolicitud(
                    solicitud,
                    otroUsuario
            )
    );

    verify(solicitudRepository, never()).actualizar(solicitud);

    verify(auditoriaService, never()).registrarAccion(
            solicitud.getId(),
            "SOLICITUD_CERRADA",
            otroUsuario
    );
}

@Test
void noDebePermitirQueOtroUsuarioElimineLaSolicitud() {

    SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
    ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
    AuditoriaService auditoriaService = mock(AuditoriaService.class);

    WorkflowService workflowService = new WorkflowService(
            solicitudRepository,
            comentarioRepository,
            auditoriaService
    );

    Usuario creador = new Usuario();
    creador.setId(1L);

    Usuario otroUsuario = new Usuario();
    otroUsuario.setId(2L);
    otroUsuario.setActivo(true);

    Solicitud solicitud = new Solicitud();
    solicitud.setId(10L);
    solicitud.setIdUsuarioCreador(creador.getId());
    solicitud.setEstado(EstadoSolicitud.BORRADOR);

    assertThrows(
            IllegalArgumentException.class,
            () -> workflowService.eliminarSolicitud(
                    solicitud,
                    otroUsuario
            )
    );

    verify(solicitudRepository, never()).actualizar(solicitud);

    verify(auditoriaService, never()).registrarAccion(
            solicitud.getId(),
            "SOLICITUD_ELIMINADA",
            otroUsuario
    );
}

@Test
void supervisorDistintoDelCreadorPuedeAprobarSolicitud() {

    SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
    ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
    AuditoriaService auditoriaService = mock(AuditoriaService.class);

    WorkflowService workflowService = new WorkflowService(
            solicitudRepository,
            comentarioRepository,
            auditoriaService
    );

    Usuario supervisor = new Usuario();
    supervisor.setId(2L);
    supervisor.setPerfil(PerfilUsuario.SUPERVISOR);
    supervisor.setActivo(true);

    Solicitud solicitud = new Solicitud();
    solicitud.setId(10L);
    solicitud.setIdUsuarioCreador(1L);
    solicitud.setEstado(EstadoSolicitud.EN_REVISION);

    workflowService.aprobarSolicitud(solicitud, supervisor);

    verify(solicitudRepository).actualizar(solicitud);

    verify(auditoriaService).registrarAccion(
            solicitud.getId(),
            "SOLICITUD_APROBADA",
            supervisor
    );
}

@Test
void creadorPuedeCerrarSolicitudAprobada() {

    SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
    ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
    AuditoriaService auditoriaService = mock(AuditoriaService.class);

    WorkflowService workflowService = new WorkflowService(
            solicitudRepository,
            comentarioRepository,
            auditoriaService
    );

    Usuario creador = new Usuario();
    creador.setId(1L);
    creador.setActivo(true);

    Solicitud solicitud = new Solicitud();
    solicitud.setId(10L);
    solicitud.setIdUsuarioCreador(1L);
    solicitud.setEstado(EstadoSolicitud.APROBADA);

    workflowService.cerrarSolicitud(solicitud, creador);

    verify(solicitudRepository).actualizar(solicitud);

    verify(auditoriaService).registrarAccion(
            solicitud.getId(),
            "SOLICITUD_CERRADA",
            creador
    );
}
@Test
void creadorPuedeEliminarSolicitudBorrador() {

    SolicitudRepository solicitudRepository = mock(SolicitudRepository.class);
    ComentarioRepository comentarioRepository = mock(ComentarioRepository.class);
    AuditoriaService auditoriaService = mock(AuditoriaService.class);

    WorkflowService workflowService = new WorkflowService(
            solicitudRepository,
            comentarioRepository,
            auditoriaService
    );

    Usuario creador = new Usuario();
    creador.setId(1L);
    creador.setActivo(true);

    Solicitud solicitud = new Solicitud();
    solicitud.setId(10L);
    solicitud.setIdUsuarioCreador(1L);
    solicitud.setEstado(EstadoSolicitud.BORRADOR);

    workflowService.eliminarSolicitud(solicitud, creador);

    verify(solicitudRepository).actualizar(solicitud);

    verify(auditoriaService).registrarAccion(
            solicitud.getId(),
            "SOLICITUD_ELIMINADA",
            creador
    );
}

}