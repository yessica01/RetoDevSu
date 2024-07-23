package co.com.devsu.certificacion.aplicativosauce.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/inicio_de_sesion.feature",
        glue = "co.com.devsu.certificacion.aplicativosauce.stepdefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class InicioDeSesionRunner {
}
