package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaTuCarrito;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Verificar implements Task {

    @Override
    @Step("{0} Ir a verificar la compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaTuCarrito.BOTON_CHECKOUT));
    }
    public static Verificar compra() {
        return instrumented(Verificar.class);
    }
}