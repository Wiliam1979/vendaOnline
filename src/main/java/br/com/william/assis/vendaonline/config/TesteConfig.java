package br.com.william.assis.vendaonline.config;

import br.com.william.assis.vendaonline.service.DBservice;
import br.com.william.assis.vendaonline.service.EmailService;
import br.com.william.assis.vendaonline.service.MockEmailService;
import br.com.william.assis.vendaonline.service.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("development")
public class TesteConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        dBservice.instantiateTestDataBase();
        return true;
    }
  /*  @Bean
    public EmailService emailService(){
        return new MockEmailService();
    } */


    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }

}