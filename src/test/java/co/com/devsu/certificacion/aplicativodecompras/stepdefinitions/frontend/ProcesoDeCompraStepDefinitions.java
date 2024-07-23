package co.com.devsu.certificacion.aplicativodecompras.stepdefinitions.frontend;

import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.AgregarProducto;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.CancelarCompra;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.ConsultarCarritoDe;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.ContinuarCompra;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.DiligenciarFormularioDe;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.FinalizarCompraDe;
import co.com.devsu.certificacion.aplicativodecompras.tasks.frontend.Verificar;
import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaDatosDeEnvio;
import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaInicioDeSesion;
import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaProductos;
import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaTuCarrito;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.BOTON_REMOVE_NO_PRESENTE;
import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.ICONO_CARRITO_NO_PRESENTE;
import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.PRODUCTO_NO_DISPONIBLE_EN_PANTALLA;
import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.TITULO_NO_DISPONIBLE_EN_PANTALLA;
import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.ConvertirTiposDeVariable.convertStringToInt;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ProcesoDeCompraStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;
    private final Actor actor = Actor.named("usuario");
    private PaginaInicioDeSesion paginaInicioDeSesion;

    @Before
    public void setUp() {
        actor.can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }

    @Entonces("visualiza en el carrito de compras")
    public void visualizaEnElCarritoDeCompras() {
        actor.should(seeThat(WebElementQuestion.the(PaginaProductos.ICONO_TO_CART), WebElementStateMatchers.isPresent())
                .orComplainWith(AssertionError.class, ICONO_CARRITO_NO_PRESENTE));
    }

    @Cuando("agrega el producto número {string} al carrito")
    public void agregaElProductoNumeroAlCarrito(String producto) {
        actor.attemptsTo(AgregarProducto.alCarrito(convertStringToInt(producto)));
    }

    @Cuando("agrega productos al carrito y lo verifica {string}")
    public void verificaElCarrito(String producto) {
        actor.attemptsTo(AgregarProducto.alCarrito(convertStringToInt(producto)),
                ConsultarCarritoDe.compras(),
                Verificar.compra());
    }

    @Cuando("agrega productos al carrito y lo consulta {string}")
    public void consultaElCarrito(String producto) {
        actor.attemptsTo(AgregarProducto.alCarrito(convertStringToInt(producto)),
                ConsultarCarritoDe.compras());
    }

    @Cuando("cancela la compra {string} {string} {string}")
    public void cancelaLaCompra(String primerNombre, String segundoNombre, String codigoPostal) {
        actor.attemptsTo(DiligenciarFormularioDe.datosDeEnvio(primerNombre, segundoNombre, codigoPostal),
                CancelarCompra.enProceso(PaginaTuCarrito.BOTON_CANCELAR_COMPRA));
    }

    @Entonces("se presentan pantalla con la información de los productos agregados {string}")
    public void sePresentanPantallaConLaInformacionDeLosProductosAgregados(String producto) {
        actor.should(seeThat(WebElementQuestion.the(PaginaProductos.ITEM_DEL_PRODUCTOS(convertStringToInt(producto))),
                WebElementStateMatchers.isVisible())
                .orComplainWith(AssertionError.class, PRODUCTO_NO_DISPONIBLE_EN_PANTALLA));
    }

    @Cuando("continua con la compra")
    public void continuaConLaCompra() {
        Random random = new Random();
        int itemProducto = random.nextInt(5) + 1;
        actor.attemptsTo(ContinuarCompra.enProceso(PaginaTuCarrito.BOTON_CONTINUAR_COMPRA),
                AgregarProducto.alCarrito(itemProducto));
    }

    @Entonces("se presenta pantalla de productos disponibles")
    public void sePresentaPantallaDeProductosDisponibles() {
        actor.should(seeThat(WebElementQuestion.the(PaginaProductos.TITULO_PRODUCTOS), WebElementStateMatchers.isVisible())
                .orComplainWith(AssertionError.class, TITULO_NO_DISPONIBLE_EN_PANTALLA));
    }

    @Entonces("se presenta pantalla de productos disponibles con la opción de remover cada producto del carrito")
    public void sePresentaPantallaDeProductosDisponiblesConLaOpcionDeRemoverCadaProductoDelCarrito() {
        actor.should(seeThat(WebElementQuestion.the(PaginaProductos.CART_CONTAINER), WebElementStateMatchers.isVisible())
                .orComplainWith(AssertionError.class, TITULO_NO_DISPONIBLE_EN_PANTALLA));
        actor.should(seeThat(WebElementQuestion.the(PaginaProductos.BOTON_REMOVE), WebElementStateMatchers.isVisible())
                .orComplainWith(AssertionError.class, BOTON_REMOVE_NO_PRESENTE));
    }

    @Cuando("completa la compra {string} {string} {string}")
    public void completaLaCompra(String primerNombre, String segundoNombre, String codigoPostal) {
        actor.attemptsTo(DiligenciarFormularioDe.datosDeEnvio(primerNombre, segundoNombre, codigoPostal),
                FinalizarCompraDe.productos());
    }

    @Entonces("se presenta pantalla de compra realizada correctamente")
    public void sePresentaPantallaDeCompraRealizadaCorrectamente() {
        actor.should(seeThat(WebElementQuestion.the(PaginaDatosDeEnvio.ORDEN_COMPLETADA), WebElementStateMatchers.isVisible()));
    }

}