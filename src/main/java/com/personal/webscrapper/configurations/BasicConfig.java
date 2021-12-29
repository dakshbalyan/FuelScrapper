package com.personal.webscrapper.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class BasicConfig {

    @Bean
    @Primary
    public Properties getProperties(){
        Properties properties = new Properties();
        InputStream inputStream = null;
        try{
            inputStream = this.getClass().getClassLoader()
                    .getResourceAsStream("application.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }
}
