package cl.j3duardogarci4.solicitudes.presentation.solicitud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.j3duardogarci4.solicitudes.application.solicitud.BuscarSolicitudUseCase;
import cl.j3duardogarci4.solicitudes.application.solicitud.CrearSolicitudUseCase;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.presentation.solicitud.dto.CrearSolicitudRequest;

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
    public ResponseEntity<Solicitud> crear(@RequestBody CrearSolicitudRequest request) {

        Solicitud solicitud = crearSolicitudUseCase.ejecutar(request);

        return ResponseEntity.ok(solicitud);
    }
}
