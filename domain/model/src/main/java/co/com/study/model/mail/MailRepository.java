package co.com.study.model.mail;

import co.com.study.model.restaurante.Restaurante;

public interface MailRepository {

    void sendMessage(String message, String address);


    void sendMessageRestaurante(Restaurante restaurante, String address);
}
