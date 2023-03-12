package spring.fortune;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Have a RESTful day.";
    }
}

