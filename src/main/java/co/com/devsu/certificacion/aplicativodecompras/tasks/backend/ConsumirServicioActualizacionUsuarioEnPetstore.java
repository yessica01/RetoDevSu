package co.com.devsu.certificacion.aplicativodecompras.tasks.backend;

import co.com.devsu.certificacion.aplicativodecompras.exceptions.ManejoDeExcepcion;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.ERROR_AL_CONSUMIR_SERVICIO;

public class ConsumirServicioActualizacionUsuarioEnPetstore implements Task {
    private String recurso;

    public ConsumirServicioActualizacionUsuarioEnPetstore(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} Consumir el servicio actualización de usuario existen en petstore")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(recurso)
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)));
        if (SerenityRest.lastResponse().statusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            throw new ManejoDeExcepcion(ERROR_AL_CONSUMIR_SERVICIO);
        }
    }

    public static ConsumirServicioActualizacionUsuarioEnPetstore con(String recurso) {
        return Tasks.instrumented(ConsumirServicioActualizacionUsuarioEnPetstore.class, recurso);
    }
}