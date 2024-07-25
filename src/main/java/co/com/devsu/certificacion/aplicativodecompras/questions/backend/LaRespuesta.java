package co.com.devsu.certificacion.aplicativodecompras.questions.backend;

import co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.devsu.certificacion.aplicativodecompras.utils.backend.MensajesDeRespuesta.valueOf;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class LaRespuesta implements Question<Boolean> {

    private final String estado;

    private LaRespuesta(String estado) {
        this.estado = estado;
    }

    @Override
    @Step("{0} Validar respuesta del servicio")
    public Boolean answeredBy(Actor actor) {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(valueOf(estado).getCodigoRespuesta()))
                        .orComplainWith(AssertionError.class, Constants.CODIGO_ERROR));
        return true;
    }

    public static LaRespuesta delServicioEs(String estado) {
        return new LaRespuesta(estado);
    }
}
