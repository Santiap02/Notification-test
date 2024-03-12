package co.com.study.sesadapter;

import co.com.study.model.mail.MailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.SendEmailRequest;

import java.io.IOException;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SesAdapter implements MailRepository {

    private final MailSender mailSender;

    private final Configuration freemarkerConfig;

    private final SesV2Client sesV2Client;

    private final ObjectMapper mapper;

    private static final String FROM = "s10308073@hotmail.com";


    @Override
    public void sendSimpleMail(Object message, String address, String subject) {
        var mail=  new SimpleMailMessage();
        mail.setFrom(FROM);
        mail.setTo(address);
        mail.setSubject(subject);
        mail.setText(message.toString());
        mailSender.send(mail);
    }

    @Override
    public void sendMessageTemplate(Object data, String address, String subject) {
        sesV2Client.sendEmail(
                SendEmailRequest.builder()
                .destination(builder -> builder.toAddresses(address))
                .content(builder -> builder
                        .simple(builder1 -> builder1
                                .body(builder2 -> builder2
                                        .html(builder3 -> builder3
                                                .data(templateGenerator(data))))
                                .subject(builder2 -> builder2.data(subject).build()).build())
                )
                .fromEmailAddress(FROM)
                .build());
    }


    public String templateGenerator(Object fields) {
        try{
            return FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkerConfig.getTemplate("template.ftl")
                            , mapper.convertValue(fields, Map.class));
        } catch (TemplateException | IOException e) {
            log.error("Error al procesar el template", e);
            return "";
        }
    }




}
