package dev.jav.foro.domain.usuario;

public record DatosTokenJwt(
        String jwtToken,
        String expiracion) {
}
