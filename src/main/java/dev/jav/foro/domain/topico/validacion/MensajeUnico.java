package dev.jav.foro.domain.topico.validacion;

import dev.jav.foro.domain.topico.DatosCrearTopico;
import dev.jav.foro.model.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MensajeUnico implements ValidadorDeTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearTopico datos) {
        if(datos.mensaje() != null) {
            boolean esUnico = topicoRepository.existsByMensaje(datos.mensaje());
            if(esUnico) {
                throw new ValidationException("El mensaje del tópico ya existe");
            }
        }
    }
}
