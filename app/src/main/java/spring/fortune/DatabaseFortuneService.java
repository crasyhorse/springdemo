package spring.fortune;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "SELECT fortune FROM table.";
    }
}
