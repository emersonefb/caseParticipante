package br.com.efb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigDEV// define qual ambiente será usuado essa config
public class BackEndConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Back-End";
    }
}
