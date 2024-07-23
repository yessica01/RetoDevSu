package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaTuCarrito;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarCarritoDe implements Task {

    @Override
    @Step("{0} Ir al carrito donde se agregaron los productos seleccionados")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaTuCarrito.INCONO_CARRITO));
    }

    public static ConsultarCarritoDe compras() {
        return instrumented(ConsultarCarritoDe.class);
    }
}
