package ru.totalexx.mod1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("ru.totalexx.mod1")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {

}
