package co.com.devsu.certificacion.aplicativodecompras.stepdefinitions.backend;

import co.com.devsu.certificacion.aplicativodecompras.models.backend.InformacionDeUsuarioPetstore;
import co.com.devsu.certificacion.aplicativodecompras.questions.backend.LaRespuesta;
import co.com.devsu.certificacion.aplicativodecompras.tasks.backend.ConsumirServicioActualizacionUsuarioEnPetstore;
import co.com.devsu.certificacion.aplicativodecompras.tasks.backend.ConsumirServicioConsultaUsuarioEnPetstore;
import co.com.devsu.certificacion.aplicativodecompras.tasks.backend.ConsumirServicioCreacionUsuarioEnPetstore;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static co.com.devsu.certificacion.aplicativodecompras.utils.backend.MensajesDeRespuesta.valueOf;

import co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.util.List;
import java.util.Map;

import static co.com.devsu.certificacion.aplicativodecompras.utils.backend.LeeUnaVariable.getVariable;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CreacionDeUsuarioEnPetstoreStepDefinitions {
    private EnvironmentVariables variablesDeEntorno;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("usuario");
    }
    @Cuando("se consume el servicio crear nuevo usuario {string}")
    public void seConsumeElServicioCrearNuevoUsuario(String endpoint, List<Map<String, String>> datosBasicos) {
    InformacionDeUsuarioPetstore informacion = new InformacionDeUsuarioPetstore(datosBasicos);
        theActorInTheSpotlight().whoCan(CallAnApi.at(getVariable(variablesDeEntorno, endpoint)))
                .attemptsTo(ConsumirServicioCreacionUsuarioEnPetstore.con(informacion, ""));
    }

    @Entonces("Entonces verá el status {string} consumo exitoso")
    public void entoncesVeraElStatusConsumoExitoso(String estado) {
        theActorInTheSpotlight().should(
                seeThat(LaRespuesta.delServicioEs(estado)));
    }

    @Cuando("se consume el servicio de consultar {string} con {string} usuario creado")
    public void seConsumeElServicioConUsuarioCreado(String endpoint, String usuario) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(getVariable(variablesDeEntorno, endpoint)+usuario))
                .attemptsTo(ConsumirServicioConsultaUsuarioEnPetstore.con(usuario));
    }

    @Entonces("la estructura de la respuesta es la esperada {string} {string}")
    public void laEstructuraDeLaRespuestaEsLaEsperada(String schema, String respuesta) {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(valueOf(respuesta).getCodigoRespuesta())
                        .body(matchesJsonSchemaInClasspath("Schemas/" + schema + ".json")))
                        .orComplainWith(AssertionError.class, Constants.ESTRUCTURA_NO_ESPERADA));
    }

    @Cuando("se consume el servicio actualizar {string} con {string} usuario creado")
    public void seConsumeElServicioActualizarConUsuarioCreado(String endpoint, String usuario) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(getVariable(variablesDeEntorno, endpoint)+usuario))
                .attemptsTo(ConsumirServicioConsultaUsuarioEnPetstore.con(""));
    }

    @Cuando("se consume el servicio eliminar {string} con {string} usuario creado")
    public void seConsumeElServicioEliminarConUsuarioCreado(String endpoint, String usuario) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(getVariable(variablesDeEntorno, endpoint)+usuario))
                .attemptsTo(ConsumirServicioActualizacionUsuarioEnPetstore.con(""));
    }
}