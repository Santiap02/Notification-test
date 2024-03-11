package co.com.study.sesadapter;

import co.com.study.model.mail.MailRepository;
import io.awspring.cloud.ses.SimpleEmailServiceJavaMailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class SesAdapter implements MailRepository {

    private final MailSender mailSender;


    private final JavaMailSender javaMailSender;

    private final SimpleEmailServiceJavaMailSender sender;
    @Override
    public void sendMessage(String message, String address) {
        var mail=  new SimpleMailMessage();
        mail.setFrom("s10308073@hotmail.com");
        mail.setTo(address);
        mail.setSubject("Pruebas");
        mail.setText(message);
        mailSender.send(mail);
    }

    void sendTemplate(SimpleMailMessage simpleMailMessage) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            //helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
            helper.setTo(Objects.requireNonNull(simpleMailMessage.getTo()));
            helper.setText(Objects.requireNonNull(simpleMailMessage.getText()));
            helper.setSubject(Objects.requireNonNull(simpleMailMessage.getSubject()));
            helper.setFrom(Objects.requireNonNull(simpleMailMessage.getFrom()));
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
