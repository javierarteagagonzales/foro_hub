package dev.jav.foro.controller;

import dev.jav.foro.domain.usuario.DatosUsuario;
import dev.jav.foro.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<DatosUsuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosUsuario> obtenerUsuario(@PathVariable Long id) {
        DatosUsuario usuario = usuarioService.obtenerUsuario(id);
        if (usuario == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuario);
    }

}
