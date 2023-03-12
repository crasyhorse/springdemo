package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import spring.coach.SwimCoach;
import spring.fortune.FortuneService;
import spring.fortune.SadFortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
    
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
