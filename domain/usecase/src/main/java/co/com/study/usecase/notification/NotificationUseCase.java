package co.com.study.usecase.notification;

import co.com.study.model.mail.MailRepository;
import co.com.study.model.restaurante.Restaurante;
import co.com.study.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class NotificationUseCase {

    private final MailRepository mailRepository;

    private final UsuarioRepository usuarioRepository;

    public void sendRestauranteNotification(Restaurante restauranteInput){
        Mono.just(restauranteInput)
                .doOnNext(restaurante -> log.warn("Empieza")).flatMap(restaurante1 ->
                        usuarioRepository.findById(restaurante1.getIdPropietario())
                                .doOnNext(usuario -> log.warn(usuario.toString()))
                                .map(usuario -> restauranteInput.toBuilder().propietario(usuario).build()))
                .doOnNext(s -> log.warn("Usuario asignado: " + s.toString()))
                .doOnNext(restaurante -> sendNotification(restaurante, restaurante.getPropietario().getEmail()))
                .subscribe();
    }

    public void sendNotification(Restaurante message, String address){
        mailRepository.sendMessageTemplate(message,address, "Mensaje de prueba");
        log.error(message.toString());
    }

}
