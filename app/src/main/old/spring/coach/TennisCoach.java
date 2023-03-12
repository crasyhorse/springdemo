package spring.coach;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.fortune.FortuneService;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    public TennisCoach() {
        System.out.println(">> inside TennisCoach");
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">> TennisCoach: inside destroy()");
    }
}
