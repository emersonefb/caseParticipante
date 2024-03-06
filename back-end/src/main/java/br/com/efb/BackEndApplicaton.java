package br.com.efb;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ConfigurationPropertiesScan
public class BackEndApplicaton extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BackEndApplicaton.class,args);
    }

    @Bean
    public CommandLineRunner startComand(){
        return args -> {
            System.out.println("Start");
        };
    }
    @Value("${application.Name}")
    private String applicationName;

}
