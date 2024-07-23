package co.com.devsu.certificacion.aplicativodecompras.runners.frontend;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/frontend/proceso_de_compra_sauce.feature",
        glue = "co.com.devsu.certificacion.aplicativodecompras.stepdefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class ProcesoDeComprasSauceRunner {
}
