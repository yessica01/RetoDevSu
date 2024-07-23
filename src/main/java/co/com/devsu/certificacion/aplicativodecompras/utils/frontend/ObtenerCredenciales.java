package co.com.devsu.certificacion.aplicativodecompras.utils.frontend;

import java.util.Arrays;

public class ObtenerCredenciales {

    private final String usuariosDisponibles;
    private final String indiceDeUsuarioDeseado;
    private final String claveDisponible;


    public ObtenerCredenciales(String usuariosDisponibles, String indiceDeUsuarioDeseado, String claveDisponible){
        this.usuariosDisponibles = usuariosDisponibles;
        this.indiceDeUsuarioDeseado = indiceDeUsuarioDeseado;
        this.claveDisponible = claveDisponible;
    }

    public  String obtenerUsuario(){
        String[] listaDeUsuariosDisponibles = usuariosDisponibles.split("\\R");
    return Arrays.asList(listaDeUsuariosDisponibles).get(Integer.parseInt(indiceDeUsuarioDeseado));
    }

    public  String obtenerClave(){
        String[] listaDeclavesDisponibles = claveDisponible.split("\\R");
        return Arrays.asList(listaDeclavesDisponibles).get(1);
    }
}