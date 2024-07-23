package co.com.devsu.certificacion.aplicativosauce.userinterface;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaProductos {
    public static final Target TITULO_PRODUCTOS = Target.the("Encabezado de la página en la que se ofrecen los productos").locatedBy("//span[contains(text(),'Products')]");
    public static final Target BOTON_ADD_TO_CART = Target.the("Botón agregar al carrito").locatedBy("//button[@class='btn btn_primary btn_small btn_inventory']");
    public static final Target BOTON_REMOVE = Target.the("Producto con el botón Remover habilitado").locatedBy("//div[@class='pricebar']//*[contains(text(), 'Remove')]");

    public static final Target ITEM_DEL_PRODUCTOS(int item){
        return Target.the("Identificador del producto a elegir").locatedBy("//a[@id='item_"+item+"_title_link']");}

}

