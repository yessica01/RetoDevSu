package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaInicioDeSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarInformacionDe implements Task {
    private final String usuario;
    private final String clave;

    public IngresarInformacionDe(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override

    @Step("{0} Ingresar información para inicio de sesion")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(usuario).into(PaginaInicioDeSesion.USUARIO_INPUT),
                Enter.theValue(clave).into(PaginaInicioDeSesion.CLAVE_INPUT),
                Click.on(PaginaInicioDeSesion.BOTON_LOGIN));
    }

    public static IngresarInformacionDe inicioDeSesionCon(String usuario, String clave) {
        return instrumented(IngresarInformacionDe.class, usuario, clave);
    }
}