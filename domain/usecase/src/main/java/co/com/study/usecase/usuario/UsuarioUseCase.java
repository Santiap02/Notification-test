package co.com.study.usecase.usuario;

import co.com.study.model.usuario.Usuario;
import co.com.study.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Mono<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

}
