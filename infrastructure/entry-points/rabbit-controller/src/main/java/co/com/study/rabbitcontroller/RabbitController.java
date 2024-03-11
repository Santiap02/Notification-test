package co.com.study.rabbitcontroller;

import co.com.study.model.restaurante.Restaurante;
import co.com.study.usecase.notification.NotificationUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitController {

    private final ObjectMapper mapper;

    private final NotificationUseCase notificationUseCase;


    @RabbitListener(queues = "queue1", ackMode = "AUTO")
    public void listenQueue1(String message) throws JsonProcessingException {
        notificationUseCase.sendRestauranteNotification(mapper.readValue(message, Restaurante.class));
        //log.warn("resultado: " + x.toString());
        //notificationUseCase.sendNotification(message);

    }

}
