package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaDatosDeEnvio;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinalizarCompraDe implements Task {

    @Override
    @Step("{0} Finalizar compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaDatosDeEnvio.BOTON_FINALIZAR));
    }
    public static FinalizarCompraDe productos() {
        return instrumented(FinalizarCompraDe.class);
    }
}