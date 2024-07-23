package co.com.devsu.certificacion.aplicativodecompras.runners.frontend;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/frontend/inicio_de_sesion.feature",
        glue = "co.com.devsu.certificacion.aplicativodecompras.stepdefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class InicioDeSesionRunner {
}
