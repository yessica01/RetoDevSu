package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaDatosDeEnvio;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DiligenciarFormularioDe implements Task {
    private final String primerNombre;
    private final String segundoNombre;
    private final String codigoPostal;

    public DiligenciarFormularioDe(String primerNombre, String segundoNombre, String codigoPostal){
      this.primerNombre = primerNombre;
      this.segundoNombre = segundoNombre;
      this.codigoPostal = codigoPostal;
    }
    @Override

    @Step("{0} Diligenciar formulario datos de envio")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(primerNombre).into(PaginaDatosDeEnvio.TEXT_BOX_PRIMER_NOMBRE),
                Enter.theValue(segundoNombre).into(PaginaDatosDeEnvio.TEXT_BOX_SEGUNDO_NOMBRE),
                Enter.theValue(codigoPostal).into(PaginaDatosDeEnvio.TEXT_BOX_CODIGO_POSTAL),
                Click.on(PaginaDatosDeEnvio.BOTON_CONTINAR));
    }

    public static DiligenciarFormularioDe datosDeEnvio(String primerNombre, String segundoNombre, String codigoPostal) {
        return instrumented(DiligenciarFormularioDe.class, primerNombre, segundoNombre, codigoPostal);
    }
}
