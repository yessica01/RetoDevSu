package co.com.devsu.certificacion.aplicativodecompras.tasks.frontend;

import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaProductos;
import co.com.devsu.certificacion.aplicativodecompras.userinterface.PaginaTuCarrito;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AgregarProducto implements Task {

    private int item;
    public AgregarProducto(int item){
        this.item = item;
    }
    @Override
    @Step("{0} Agregar producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaProductos.ITEM_DEL_PRODUCTOS(item)),
                Click.on(PaginaProductos.BOTON_ADD_TO_CART),
                Click.on(PaginaTuCarrito.INCONO_CARRITO));
    }

    public static AgregarProducto alCarrito(int item) {
        return instrumented(AgregarProducto.class, item);
    }
}
