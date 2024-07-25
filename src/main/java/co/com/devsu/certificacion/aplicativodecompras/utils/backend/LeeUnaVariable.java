package co.com.devsu.certificacion.aplicativodecompras.utils.backend;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class LeeUnaVariable {
    private LeeUnaVariable() {}

    public static String getVariable(EnvironmentVariables environmentVariables, String variable) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(variable);
    }
}
