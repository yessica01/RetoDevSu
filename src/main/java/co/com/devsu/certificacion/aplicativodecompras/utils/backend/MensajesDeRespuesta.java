package co.com.devsu.certificacion.aplicativodecompras.utils.backend;

public enum
MensajesDeRespuesta {

    OK(200, "HTTP/1.1 200 OK"),
    PAGE_NOT_FOUND(404, "Page Not Found"),
    FORBIDDEN(403, "Forbidden"),
    BAD_REQUEST(400, "Bad Request");

    private int codigoRespuesta;
    private String mensajeRespuesta;

    private MensajesDeRespuesta(int codigoRespuesta, String mensajeRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }
}