package spring.coach;

import org.springframework.stereotype.Component;

import spring.fortune.FortuneService;

@Component
public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {}

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public void doMyStartupStuff() {
        System.out.println("Do my startup stuff now!");
    }

    public void doMyCleanupStuff() {
        System.out.println("Do my cleanup stuff!");
    }
}
