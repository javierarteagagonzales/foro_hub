package dev.jav.foro.infra.error;

public class ValidacionDeIntegridad extends RuntimeException {

    public ValidacionDeIntegridad(String message) {
        super(message);
    }

}
