package cl.j3duardogarci4.solicitudes.presentation.error;

import java.util.Map;

public class ValidationErrorResponse {

    private String codigo;
    private String mensaje;
    private Map<String, String> errores;

    public ValidationErrorResponse() {
    }

    public ValidationErrorResponse(
            String codigo,
            String mensaje,
            Map<String, String> errores) {

        this.codigo = codigo;
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
}