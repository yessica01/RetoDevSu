package co.com.devsu.certificacion.aplicativodecompras.userinterface;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaDatosDeEnvio {
    public static final Target TEXT_BOX_PRIMER_NOMBRE = Target.the("Caja de texto para el primer nombre").locatedBy("//input[@id='first-name']");
    public static final Target TEXT_BOX_SEGUNDO_NOMBRE = Target.the("Caja de texto para el segundo nombre").locatedBy("//input[@id='last-name']");
    public static final Target TEXT_BOX_CODIGO_POSTAL = Target.the("Caja de texto para el código postal").locatedBy("//input[@id='postal-code']");
    public static final Target BOTON_CONTINAR = Target.the("Botón para continuar con la compra del producto").locatedBy("//input[@id='continue']");
    public static final Target BOTON_FINALIZAR = Target.the("Botón para finalizar la compra").locatedBy("//button[@id='finish']");
    public static final Target ORDEN_COMPLETADA = Target.the("Pantalla que indica que la orden fue completada y será despachada").locatedBy("//div[@id='checkout_complete_container' and //@class = 'complete-text']");
}

