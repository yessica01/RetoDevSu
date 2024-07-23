package co.com.devsu.certificacion.aplicativosauce.stepdefinitions;

import co.com.devsu.certificacion.aplicativosauce.questions.LaPaginaEsperada;
import co.com.devsu.certificacion.aplicativosauce.tasks.AbrirElNavegador;
import co.com.devsu.certificacion.aplicativosauce.tasks.IngresarInformacionDe;
import co.com.devsu.certificacion.aplicativosauce.userinterface.PaginaInicioDeSesion;
import co.com.devsu.certificacion.aplicativosauce.utils.DatosDeInicioDeSesion;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class InicioDeSesionStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;
    private final Actor actor = Actor.named("Actor");
    private PaginaInicioDeSesion paginaInicioDeSesion;

    @Before
    public void setUp() {
        actor.can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }

    @Dado("que el usuario visita el sitio web de la empresa saucedemo.com")
    public void queElUsuarioVisitaElSitioWeb() {
        actor.wasAbleTo(AbrirElNavegador.en(paginaInicioDeSesion));
    }

    @Cuando("el usuario inicia sesion con usuario y contraseña del perfil {string} {string}")
    public void iniciaSesionConUsuarioYContrasenaDelPerfil(String posicionDeUsuarioEnPantalla, String datosCorrectos) {
        String usuariosDisponibles = String.valueOf(PaginaInicioDeSesion.NOMBRE_USUARIO.resolveFor(actor).getText());
        String claveDisponible = String.valueOf(PaginaInicioDeSesion.CLAVE.resolveFor(actor).getText());

        DatosDeInicioDeSesion datosDeInicioDeSesion = new DatosDeInicioDeSesion(posicionDeUsuarioEnPantalla, datosCorrectos, usuariosDisponibles, claveDisponible);
        actor.attemptsTo(IngresarInformacionDe.inicioDeSesionCon(
                datosDeInicioDeSesion.usuarioYclave().get(0),
                datosDeInicioDeSesion.usuarioYclave().get(1)));
    }

    @Entonces("se muestra la pantalla principal del sitio web {string}")
    public void seMuestraLaPantallaPrincipalDelSitioWeb(String nombrePantalla) {
        actor.should(
                seeThat(LaPaginaEsperada.valor(), equalTo(nombrePantalla)));
    }

    @Entonces("se muestra mensaje de error porque los datos ingresados no corresponden a los disponibles")
    public void seMuestraMensajeDeRrrorPorqueLosDatosIngresadosNoCorrespondenAlosDisponibles() {
        actor.should(seeThat(WebElementQuestion.the(PaginaInicioDeSesion.MENSAJE_ERROR), WebElementStateMatchers.isVisible()));
    }

    @Entonces("se muestra un mensaje informativo por usuario bloqueado")
    public void se_muestraUnMensajeInformativoPorUsuarioBloqueado() {
        actor.should(seeThat(WebElementQuestion.the(PaginaInicioDeSesion.MENSAJE_USUARIO_BLOQUEADO), WebElementStateMatchers.isVisible()));
    }
}
