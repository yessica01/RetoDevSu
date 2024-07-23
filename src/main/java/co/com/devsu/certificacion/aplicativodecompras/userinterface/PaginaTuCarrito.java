package co.com.devsu.certificacion.aplicativodecompras.userinterface;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaTuCarrito {
    public static final Target INCONO_CARRITO = Target.the("Icono del carrito en la sesión tu carrito").locatedBy("//a[@class='shopping_cart_link']");
    public static final Target BOTON_CHECKOUT = Target.the("Botón para ir a verificar la compra").locatedBy("//button[@id='checkout']");
    public static final Target BOTON_CANCELAR_COMPRA = Target.the("Botón para cancelar la compra").locatedBy("//button[@id='cancel']");
    public static final Target BOTON_CONTINUAR_COMPRA = Target.the("Botón para continuar con la compra").locatedBy("//button[@id='continue-shopping']");
}

