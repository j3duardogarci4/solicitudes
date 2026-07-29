package cl.j3duardogarci4.solicitudes;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.j3duardogarci4.solicitudes.application.solicitud.BuscarSolicitudUseCase;
import cl.j3duardogarci4.solicitudes.application.solicitud.CrearSolicitudUseCase;
import cl.j3duardogarci4.solicitudes.domain.solicitud.EstadoSolicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.Solicitud;
import cl.j3duardogarci4.solicitudes.domain.solicitud.SolicitudRepository;

@SpringBootApplication
public class SolicitudesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolicitudesApplication.class, args);
    }

    @Bean
    CommandLineRunner prueba(CrearSolicitudUseCase crearSolicitudUseCase,  BuscarSolicitudUseCase buscarSolicitudUseCase) {
    return args -> {

        Solicitud solicitud = new Solicitud();

        solicitud.setDescripcion("Primera solicitud");
        solicitud.setEstado(EstadoSolicitud.BORRADOR);
        solicitud.setFechaGeneracion(LocalDateTime.now());
        solicitud.setFechaActualizacion(LocalDateTime.now());
        solicitud.setIdUsuarioCreador(1L);
        solicitud.setIdSupervisorAsignado(2L);
        
        Solicitud solicitudGuardada = crearSolicitudUseCase.ejecutar(solicitud);

        System.out.println("Solicitud guardada.");

        Long id = solicitudGuardada.getId();        
       
        Optional<Solicitud> recuperada = buscarSolicitudUseCase.ejecutar(id);


        if (recuperada.isPresent()) {
            System.out.println("Solicitud encontrada");
            System.out.println("Id: " + recuperada.get().getId());
            System.out.println("Descripción: " + recuperada.get().getDescripcion());
            System.out.println("Estado: " + recuperada.get().getEstado());
        } else {
            System.out.println("Solicitud no encontrada");
        }

      };
     }
    }

