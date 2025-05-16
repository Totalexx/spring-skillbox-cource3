package ru.totalexx.mod1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.totalexx.mod1.config.DefaultAppConfig;

public class App {

    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);

        ConsoleManager manager = context.getBean(ConsoleManager.class);
        manager.process();
    }
}
