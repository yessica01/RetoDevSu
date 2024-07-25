package co.com.devsu.certificacion.aplicativodecompras.tasks.backend;

import co.com.devsu.certificacion.aplicativodecompras.exceptions.ManejoDeExcepcion;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.ERROR_AL_CONSUMIR_SERVICIO;

public class ConsumirServicioEliminarUsuarioEnPetstore implements Task {
    private String recurso;

    public ConsumirServicioEliminarUsuarioEnPetstore(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} Consumir el servicio consulta de usuario existente en petstore")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(recurso)
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)));
        if (SerenityRest.lastResponse().statusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            throw new ManejoDeExcepcion(ERROR_AL_CONSUMIR_SERVICIO);
        }
    }
    public static ConsumirServicioEliminarUsuarioEnPetstore con(String recurso) {
        return Tasks.instrumented(ConsumirServicioEliminarUsuarioEnPetstore.class, recurso);
    }
}