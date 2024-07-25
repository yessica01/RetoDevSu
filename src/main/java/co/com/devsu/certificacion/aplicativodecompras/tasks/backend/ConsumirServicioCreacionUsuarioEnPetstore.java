package co.com.devsu.certificacion.aplicativodecompras.tasks.backend;

import co.com.devsu.certificacion.aplicativodecompras.exceptions.ManejoDeExcepcion;
import co.com.devsu.certificacion.aplicativodecompras.models.backend.InformacionDeUsuarioPetstore;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static co.com.devsu.certificacion.aplicativodecompras.utils.frontend.Constants.ERROR_AL_CONSUMIR_SERVICIO;

public class ConsumirServicioCreacionUsuarioEnPetstore implements Task {
    private InformacionDeUsuarioPetstore informacion;
    private String recurso;

    public ConsumirServicioCreacionUsuarioEnPetstore(InformacionDeUsuarioPetstore informacion, String recurso) {
        this.informacion = informacion;
        this.recurso = recurso;
    }

    @Override
    @Step("{0} Consumir el servicio creacion de usuario nuevo en petstore")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(recurso)
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)
                        .body(informacion)));
        if (SerenityRest.lastResponse().statusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            throw new ManejoDeExcepcion(ERROR_AL_CONSUMIR_SERVICIO);
        }
    }

    public static ConsumirServicioCreacionUsuarioEnPetstore con(InformacionDeUsuarioPetstore informacion, String recurso) {
        return Tasks.instrumented(ConsumirServicioCreacionUsuarioEnPetstore.class, informacion, recurso);
    }
}