package dev.jav.foro.model.repository;

import dev.jav.foro.model.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensaje(String mensaje);

}
