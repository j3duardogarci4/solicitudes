Titulo : La construcción del agregado Solicitud será responsabilidad de la capa Application
Contexto: 
Durante la implementación del endpoint de creación surgió la decisión de dónde debía construirse el objeto Solicitud.

Se evaluaron tres alternativas:
 - El controlador.
 - Un mapper.
 - El caso de uso.

Decisión
Se decidió que la creación del agregado Solicitud será responsabilidad del CrearSolicitudUseCase.
El caso de uso recibirá un DTO de entrada (CrearSolicitudRequest), construirá el objeto del dominio y delegará al propio dominio la inicialización de su estado válido.

Motivación
Se descartó realizar esta construcción en un mapper porque ello implicaría incorporar comportamiento del negocio (estado inicial, fechas, reglas de creación) en una clase cuya responsabilidad debe limitarse a transformar modelos.
También se descartó hacerlo en el controlador para evitar que la capa de presentación conozca detalles del modelo de dominio.

La decisión busca mantener:
 - Alta cohesión.
 - Baja dependencia entre capas.
 - Una única responsabilidad por clase.
 
Consecuencias
Positivas
- El controlador permanece liviano.
- El mapper conserva una única responsabilidad.
- El caso de uso representa completamente el proceso de creación.
- Las reglas de creación permanecen centralizadas.

Negativas
- El caso de uso asume mayor responsabilidad durante la creación del agregado.
- No obstante, dicha responsabilidad corresponde naturalmente a la capa Application.

Estado: Aceptado.