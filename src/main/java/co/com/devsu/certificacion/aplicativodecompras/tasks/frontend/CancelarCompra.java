package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CancelarCompra implements Task {

    private final Target btnCancelarCompra;

    public CancelarCompra(Target btnCancelarCompra) {
        this.btnCancelarCompra = btnCancelarCompra;
    }

    @Override
    @Step("{0} Cancelar compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnCancelarCompra));
    }

    public static CancelarCompra enProceso(Target btnCancelarCompra) {
        return instrumented(CancelarCompra.class, btnCancelarCompra);
    }
}