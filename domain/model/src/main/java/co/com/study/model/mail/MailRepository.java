package co.com.study.model.mail;

public interface MailRepository {

    void sendSimpleMail(Object message, String address, String subject);


    void sendMessageTemplate(Object data, String address, String subject);
}
