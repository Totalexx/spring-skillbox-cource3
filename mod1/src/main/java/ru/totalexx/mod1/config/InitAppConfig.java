package ru.totalexx.mod1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.totalexx.mod1.service.ContactLoader;
import ru.totalexx.mod1.service.ContactService;

@Configuration
@Profile("init")
public class InitAppConfig {

    private final ContactService contactService;

    public InitAppConfig(ContactService contactService) {
        this.contactService = contactService;
    }

    @Bean
    public ContactLoader contactLoader() {
        return new ContactLoader(contactService);
    }
}
