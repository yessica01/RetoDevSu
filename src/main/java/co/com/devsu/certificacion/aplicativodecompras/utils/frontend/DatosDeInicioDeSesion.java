package co.com.devsu.certificacion.aplicativodecompras.utils.frontend;

import java.util.ArrayList;
import java.util.List;

public class DatosDeInicioDeSesion {

    private final String posicionDeUsuarioEnPantalla;
    private final String datosCorrectos;
    private final String usuariosDisponibles;
    private final String claveDisponible;

    public DatosDeInicioDeSesion(String posicionDeUsuarioEnPantalla, String datosCorrectos, String usuariosDisponibles, String claveDisponible) {
        this.posicionDeUsuarioEnPantalla = posicionDeUsuarioEnPantalla;
        this.datosCorrectos = datosCorrectos;
        this.usuariosDisponibles = usuariosDisponibles;
        this.claveDisponible = claveDisponible;
    }

    public List<String> usuarioYclave() {
        ObtenerCredenciales obtenerCredenciales = new ObtenerCredenciales(usuariosDisponibles, posicionDeUsuarioEnPantalla, claveDisponible);

        String claveSeleccionada;
        String usuarioSeleccionado;
        if (datosCorrectos.equalsIgnoreCase("S")) {
            usuarioSeleccionado = obtenerCredenciales.obtenerUsuario();
            claveSeleccionada = obtenerCredenciales.obtenerClave();
        } else {
            usuarioSeleccionado = "Usuario_x";
            claveSeleccionada = "clave_x";
        }

        List<String> datosDeUsuario = new ArrayList<>();
        datosDeUsuario.add(usuarioSeleccionado);
        datosDeUsuario.add(claveSeleccionada);

        return datosDeUsuario;
    }
}