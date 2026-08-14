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
    import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
    import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.CrearSolicitudRequest;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
    import cl.j3duardogarci4.solicitudes.application.solicitud.ActualizarSolicitudUseCase;
    import org.springframework.web.bind.annotation.PutMapping;
    import jakarta.validation.Valid;



    @RestController
    @RequestMapping("/solicitudes")
    public class SolicitudController {

        private final CrearSolicitudUseCase crearSolicitudUseCase;
        private final BuscarSolicitudUseCase buscarSolicitudUseCase;
        private final ActualizarSolicitudUseCase actualizarSolicitudUseCase;

        public SolicitudController ( CrearSolicitudUseCase crearSolicitudUseCase,
                BuscarSolicitudUseCase buscarSolicitudUseCase,
                ActualizarSolicitudUseCase actualizarSolicitudUseCase){

            this.crearSolicitudUseCase = crearSolicitudUseCase;
            this.buscarSolicitudUseCase = buscarSolicitudUseCase;
            this.actualizarSolicitudUseCase = actualizarSolicitudUseCase;
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



    }