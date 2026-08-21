    package cl.j3duardogarci4.solicitudes.presentation.solicitud;

    import java.util.Optional;

    
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;

    import cl.j3duardogarci4.solicitudes.application.solicitud.BuscarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.CrearSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.RechazarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.domain.comentario.Comentario;
    import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
    import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.CrearSolicitudRequest;
    import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.RechazarSolicitudRequest;

    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
    import cl.j3duardogarci4.solicitudes.application.solicitud.ActualizarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.AprobarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.EnviarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.IniciarRevisionUseCase;


    import org.springframework.web.bind.annotation.PutMapping;
    import jakarta.validation.Valid;



    @RestController
    @RequestMapping("/solicitudes")
    public class SolicitudController {

        private final CrearSolicitudUseCase crearSolicitudUseCase;
        private final BuscarSolicitudUseCase buscarSolicitudUseCase;
        private final ActualizarSolicitudUseCase actualizarSolicitudUseCase;
        
        private final AprobarSolicitudUseCase aprobarSolicitudUseCase;
        private final RechazarSolicitudUseCase rechazarSolicitudUseCase;
        private final IniciarRevisionUseCase iniciarRevisionUseCase;
        private final EnviarSolicitudUseCase enviarSolicitudUseCase;        
        

        public SolicitudController ( CrearSolicitudUseCase crearSolicitudUseCase,
                                     BuscarSolicitudUseCase buscarSolicitudUseCase,
                                     ActualizarSolicitudUseCase actualizarSolicitudUseCase,
                                     AprobarSolicitudUseCase aprobarSolicitudUseCase,
                                     RechazarSolicitudUseCase rechazarSolicitudUseCase,
                                     EnviarSolicitudUseCase enviarSolicitudUseCase,
                                     IniciarRevisionUseCase iniciarRevisionUseCase){

            this.crearSolicitudUseCase = crearSolicitudUseCase;
            this.buscarSolicitudUseCase = buscarSolicitudUseCase;
            this.actualizarSolicitudUseCase = actualizarSolicitudUseCase;
            this.aprobarSolicitudUseCase = aprobarSolicitudUseCase;
            this.rechazarSolicitudUseCase = rechazarSolicitudUseCase;
            this.enviarSolicitudUseCase = enviarSolicitudUseCase;
            this.iniciarRevisionUseCase = iniciarRevisionUseCase;

        }
        
        @Operation(summary = "Crear una solicitud")
        @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Solicitud creada"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
})
        @PostMapping
        public ResponseEntity<Solicitud> crear(@Valid @RequestBody CrearSolicitudRequest request) {

            System.out.println(">>> Entró al controlador");

            Solicitud solicitud = crearSolicitudUseCase.ejecutar(request);

            return ResponseEntity
                .created(
                    ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(solicitud.getId())
                        .toUri()
            )
            .body(solicitud);
        }

        @Operation(summary = "Buscar una solicitud por ID")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud encontrada"),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
        })
        @GetMapping("/{id}")
        public ResponseEntity<Solicitud> buscar(@PathVariable Long id){

            Optional<Solicitud> solicitud = buscarSolicitudUseCase.ejecutar(id);

            if (solicitud.isPresent()) {
                return ResponseEntity.ok(solicitud.get());
            }

            return ResponseEntity.notFound().build(); 
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> actualizar(
                                              @PathVariable Long id,
                                              @RequestBody CrearSolicitudRequest request) {

               boolean actualizada = actualizarSolicitudUseCase.ejecutar(
                                                                        id,
                                                                        request.getDescripcion(),
                                                                        request.getIdSupervisorAsignado()
                                                                        );

               if (!actualizada) {
                    return ResponseEntity.notFound().build();
                }

               return ResponseEntity.noContent().build();
         }

        @PutMapping("/{id}/aprobar")
        public ResponseEntity<Void> aprobar(
                @PathVariable Long id,
                @RequestBody Long idSupervisor) {

            boolean aprobada = aprobarSolicitudUseCase.ejecutar(
                    id,
                    idSupervisor
            );

            if (!aprobada) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.noContent().build();
        }


        @PutMapping("/{id}/rechazar")
        public ResponseEntity<Void> rechazar(
                                            @PathVariable Long id,
                                            @RequestBody RechazarSolicitudRequest request) {

        Comentario comentario = new Comentario();
        comentario.setDescripcion(request.getComentario());

        boolean rechazada = rechazarSolicitudUseCase.ejecutar(
                id,
                request.getIdSupervisor(),
                comentario
        );

        if (!rechazada) {
            return ResponseEntity.notFound().build();
        }

            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}/enviar")
        public ResponseEntity<Void> enviar(
                    @PathVariable Long id,
                    @RequestBody Long idUsuario) {

        boolean enviada = enviarSolicitudUseCase.ejecutar( id, idUsuario);

        if (!enviada) {
            return ResponseEntity.notFound().build();
        }

            return ResponseEntity.noContent().build();
        }


        @PutMapping("/{id}/iniciar-revision")
        public ResponseEntity<Void> iniciarRevision(
                        @PathVariable Long id,
                        @RequestBody Long idSupervisor) {

        boolean iniciada = iniciarRevisionUseCase.ejecutar(id, idSupervisor);

        if (!iniciada) {
            return ResponseEntity.notFound().build();
        }

            return ResponseEntity.noContent().build();
        }
        

    }