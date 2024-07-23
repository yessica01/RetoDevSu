package co.com.devsu.certificacion.aplicativodecompras.questions.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class LaPaginaEsperada implements Question<String> {

    public static Question<String> valor() {
        return new LaPaginaEsperada();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(PaginaProductos.TITULO_PRODUCTOS).getText();
    }
}
