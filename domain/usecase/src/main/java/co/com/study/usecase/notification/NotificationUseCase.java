package co.com.study.usecase.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NotificationUseCase {

    public void sendNotification(String message){
        log.error(message);
    }

}
