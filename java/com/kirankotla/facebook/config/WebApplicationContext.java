package com.kirankotla.facebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * Created by kreddykotla
 */
@Configuration
@Import({
})
@ComponentScan(value={"com.kirankotla.facebook"})
@PropertySources({
        
        @PropertySource(name = "application", value = {
                "classpath:application-${env}.properties",
                "classpath:application.properties" }, ignoreResourceNotFound = true),
        })
public class WebApplicationContext {
    

    @Primary
    @Bean(name = "facebookObjectMapper")
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDefaultPrettyPrinter( new DefaultPrettyPrinter());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); //Stop printing dates in millis
        return objectMapper;
    }

}
