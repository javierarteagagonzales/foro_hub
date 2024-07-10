package dev.jav.foro.infra.security;

import dev.jav.foro.domain.usuario.DatosAutenticacion;
import dev.jav.foro.domain.usuario.DatosTokenJwt;
import dev.jav.foro.model.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacion datosAutenticacion) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacion.username(),
                datosAutenticacion.password()
        );
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        DatosTokenJwt tokenJwt = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(tokenJwt);
    }

}
