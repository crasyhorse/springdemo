package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import spring.properties.SomeExternalService;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class PropertiesApp {

    public static void main(final String[] args) {

        ApplicationContext appCtx = SpringApplication.run(BasicApp.class, args);
        SomeExternalService extService =
            appCtx.getBean(SomeExternalService.class);
        System.out.println(extService.returnServiceUrl());
    }
}
