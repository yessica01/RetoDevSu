package co.com.devsu.certificacion.aplicativodecompras.runners.e2e;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/e2e/realizar_compra_en_sauce.feature",
        glue = "co.com.devsu.certificacion.aplicativodecompras.stepdefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class RealizarCompraEnSauceRunner {
}
