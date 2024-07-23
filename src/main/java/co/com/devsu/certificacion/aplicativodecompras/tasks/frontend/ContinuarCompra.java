package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ContinuarCompra implements Task {
    private final Target btnContinuarCompra;

    public ContinuarCompra(Target btnContinuarCompra){
        this.btnContinuarCompra = btnContinuarCompra;
    }

    @Override
    @Step("{0} Continua con la compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(btnContinuarCompra));
    }

    public static ContinuarCompra enProceso(Target btnContinuarCompra) {
        return instrumented(ContinuarCompra.class, btnContinuarCompra);
    }
}