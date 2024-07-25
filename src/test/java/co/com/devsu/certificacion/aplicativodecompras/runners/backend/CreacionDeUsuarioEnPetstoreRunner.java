package co.com.devsu.certificacion.aplicativodecompras.runners.backend;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/backend/creacion_de_usuario_en_petstore.feature",
        glue ="co.com.devsu.certificacion.aplicativodecompras.stepdefinitions.backend",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)
public class CreacionDeUsuarioEnPetstoreRunner {

}
