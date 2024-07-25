package co.com.devsu.certificacion.aplicativodecompras.userinterface;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/")
public class PaginaInicioDeSesion extends PageObject {
    public static final Target NOMBRE_USUARIO = Target.the("Nombre de usuario").located(By.id("login_credentials"));
    public static final Target CLAVE= Target.the("Clave del usuario").locatedBy("//div[@class='login_password']");
    public static final Target USUARIO_INPUT = Target.the("Caja de texto para nombre de usuario").located(By.id("user-name"));
    public static final Target CLAVE_INPUT = Target.the("Caja de texto para contraseña").located(By.id("password"));
    public static final Target BOTON_LOGIN = Target.the("Botón login para iniciar sesión").located(By.id("login-button"));
    public static final Target MENSAJE_ERROR = Target.the("Mensaje de error por datos incorrectos para el inicio de sesión").locatedBy("//div[@class='error-message-container error']");
    public static final Target MENSAJE_USUARIO_BLOQUEADO = Target.the("Mensaje de error por usuario bloqueado").locatedBy("//div[@class='error-message-container error']//*[contains(text(),'Epic sadface: Sorry, ')]");


}
