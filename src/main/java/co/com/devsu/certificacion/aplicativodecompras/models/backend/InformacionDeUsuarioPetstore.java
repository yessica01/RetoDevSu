package co.com.devsu.certificacion.aplicativodecompras.models.backend;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
import java.util.Map;

@JsonAutoDetect
public class InformacionDeUsuarioPetstore {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;


    public InformacionDeUsuarioPetstore(List<Map<String, String>> datosBasicos) {
        this.id = Integer.parseInt(datosBasicos.get(0).get("id"));
        this.username = datosBasicos.get(0).get("username");
        this.firstName = datosBasicos.get(0).get("firstName");
        this.lastName = datosBasicos.get(0).get("lastName");
        this.email = datosBasicos.get(0).get("email");
        this.password = datosBasicos.get(0).get("password");
        this.phone = datosBasicos.get(0).get("phone");
        this.userStatus = Integer.parseInt(datosBasicos.get(0).get("userStatus"));
    }
}