package co.com.study.model.usuario.gateways;

import co.com.study.model.usuario.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioRepository {

    Mono<Usuario> findById(Long id);


}
