package co.com.study.sesadapter;

import co.com.study.model.mail.MailRepository;
import co.com.study.model.restaurante.Restaurante;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.SendEmailRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SesAdapter implements MailRepository {

    private final MailSender mailSender;


    private final JavaMailSender javaMailSender;

    private final Configuration freemarkerConfig;

    private final SesV2Client sesV2Client;


    @Override
    public void sendMessage(String message, String address) {
        log.warn("nokas");
    }

    @Override
    public void sendMessageRestaurante(Restaurante restaurante, String address) {
        var mail=  new SimpleMailMessage();
        mail.setFrom("s10308073@hotmail.com");
        mail.setTo(address);
        mail.setSubject("Pruebas");
        mail.setText(restaurante.toString());
        //mailSender.send(mail);
        //var x = EmailContent.builder().simple(Message.builder().body(Body.builder().html(Content.builder().data("Test").build()).build()).build()).build();
        SendEmailRequest request = SendEmailRequest.builder()
                .destination(builder -> builder.toAddresses(address))
                .content(builder -> builder
                        .simple(builder1 -> builder1
                                .body(builder2 -> builder2
                                        .html(builder3 -> builder3
                                                .data(templateGenerator(restaurante))))
                                .subject(builder2 -> builder2.data("Este es un mensaje de prueba").build()).build())
                        )
                .fromEmailAddress("s10308073@hotmail.com")
                .build();
        sesV2Client.sendEmail(request);
    }

    public String templateGenerator(Restaurante restaurante) {
        try{
            Template t = freemarkerConfig.getTemplate("template.ftl");
            Map<String, Object> model = new HashMap<>();
            model.put("name", restaurante.getPropetario().getNombre());
            model.put("restaurantName", "Mero restaurante");
            return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        } catch (TemplateException | IOException e) {
            log.error("Error al procesar el template", e);
            return "";
        }
    }



}
