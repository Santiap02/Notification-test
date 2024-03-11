package co.com.study;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class MainApplication {



    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup(JavaMailSender javaMailSender, Configuration freemarkerConfig, ObjectMapper mapper) {

        return args -> {
            log.info("FreeMarker");
            Template t = freemarkerConfig.getTemplate("template.ftl");
            Map<String, Object> model = new HashMap<>();
            model.put("name", "Santiago");
            model.put("restaurantName", "Mero restaurante");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        };

    }

}
