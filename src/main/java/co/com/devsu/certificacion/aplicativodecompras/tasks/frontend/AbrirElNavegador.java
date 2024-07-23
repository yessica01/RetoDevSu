package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirElNavegador implements Task {

    private final PageObject pagina;

    public AbrirElNavegador(PageObject pagina) {
        this.pagina = pagina;
    }

    @Override
    @Step("{0} Abrir el navegador en la página Sauce Swaglabs")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(pagina));
    }

    public static AbrirElNavegador en(PageObject pagina) {
        return instrumented(AbrirElNavegador.class, pagina);
    }
}
