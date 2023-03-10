package spring.coach;

import org.springframework.stereotype.Component;

import spring.fortune.FortuneService;

@Component
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach() {}

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
