package co.com.study.usecase.notification;

import co.com.study.model.helper.MapperRepository;
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

    private final MapperRepository mapper;

    private final UsuarioRepository usuarioRepository;


    public void sendRestauranteNotification2(Restaurante restauranteInput){
        var usuario = usuarioRepository.findById(restauranteInput.getId());
        Mono.just(restauranteInput).zipWith(usuario).map(tuple -> restauranteInput.toBuilder().propetario(tuple.getT2()).build())
                .doOnNext(s -> log.warn("Usuario asignado: " + s.toString()))
                .doOnNext(restaurante -> sendNotification(restaurante, restaurante.getPropetario().getEmail()))
                .subscribe();

        log.error(restauranteInput.toString());

        /*        Mono.fromCallable(() -> mapper.jacksonMap(message, Restaurante.class))
                .onErrorResume(JsonProcessingException.class, e -> {
                    log.error("Error occurred during deserialization: " + e.getMessage());
                    return Mono.empty();
                })

                .map(restaurante -> restaurante.toBuilder()
                        .propetario(usuarioUseCase.findById(restaurante.getPropetario().getId()).block()).build())
                .subscribe(s -> log.warn("Mensaje recibido: " + s.toString()));*/
    }

    public void sendRestauranteNotification(Restaurante restauranteInput){
        Mono.just(restauranteInput)
                .doOnNext(restaurante -> log.warn("Empieza")).flatMap(restaurante1 ->
                        usuarioRepository.findById(restaurante1.getIdPropietario())
                                .doOnNext(usuario -> log.warn(usuario.toString()))
                                .map(usuario -> restauranteInput.toBuilder().propetario(usuario).build()))
                .doOnNext(s -> log.warn("Usuario asignado: " + s.toString()))
                .doOnNext(restaurante -> sendNotification(restaurante, restaurante.getPropetario().getEmail()))
                .subscribe();
    }

    public void sendNotification(Restaurante message, String address){
        mailRepository.sendMessageRestaurante(message,address );
        log.error(message.toString());
    }

}
