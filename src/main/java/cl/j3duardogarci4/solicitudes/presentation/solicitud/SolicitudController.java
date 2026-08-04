    package cl.j3duardogarci4.solicitudes.presentation.solicitud;

    import java.util.Optional;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import cl.j3duardogarci4.solicitudes.application.solicitud.BuscarSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.application.solicitud.CrearSolicitudUseCase;
    import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
    import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.CrearSolicitudRequest;
    import jakarta.validation.Valid;

    @RestController
    @RequestMapping("/solicitudes")
    public class SolicitudController {

        private final CrearSolicitudUseCase crearSolicitudUseCase;
        private final BuscarSolicitudUseCase buscarSolicitudUseCase;

        public SolicitudController ( CrearSolicitudUseCase crearSolicitudUseCase,
                BuscarSolicitudUseCase buscarSolicitudUseCase){

            this.crearSolicitudUseCase = crearSolicitudUseCase;
            this.buscarSolicitudUseCase = buscarSolicitudUseCase;
        }
        
        @PostMapping
        public ResponseEntity<Solicitud> crear(@Valid @RequestBody CrearSolicitudRequest request) {

            System.out.println(">>> Entró al controlador");

            Solicitud solicitud = crearSolicitudUseCase.ejecutar(request);

            return ResponseEntity.ok(solicitud);
        }


        @GetMapping("/{id}")
        public ResponseEntity<Solicitud> buscar(@PathVariable Long id){

            Optional<Solicitud> solicitud = buscarSolicitudUseCase.ejecutar(id);

            if (solicitud.isPresent()) {
                return ResponseEntity.ok(solicitud.get());
            }

            return ResponseEntity.notFound().build(); 
        }

    }