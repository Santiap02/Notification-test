package co.com.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
@Slf4j
public class MainApplication {



    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup(JavaMailSender javaMailSender) {

        return args -> {
/*            var simpleMailMessage=  new SimpleMailMessage();
            simpleMailMessage.setFrom("s10308073@hotmail.com");
            simpleMailMessage.setTo("santiago.alvarezp@pragma.com.co");
            simpleMailMessage.setSubject("Pruebas");
            simpleMailMessage.setText("Pruebas");
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
            javaMailSender.send(simpleMailMessage);*/

        };

    }

}
