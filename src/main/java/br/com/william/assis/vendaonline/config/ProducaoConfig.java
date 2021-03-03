package br.com.william.assis.vendaonline.config;

import br.com.william.assis.vendaonline.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("production")
public class ProducaoConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        dBservice.instantiateTestDataBase();
        return true;
    }
}
