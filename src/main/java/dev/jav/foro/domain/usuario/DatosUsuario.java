package dev.jav.foro.domain.usuario;

import dev.jav.foro.model.entity.Usuario;

import java.util.List;

public record DatosUsuario(
        String username,
        String nombre,
        List<String> perfiles) {

    public DatosUsuario(Usuario input) {
        this(input.getUsername(),
            input.getNombre(),
            input.getPerfiles().stream()
                .map(perfil -> perfil.getNombre())
                .toList()
        );
    }
}
