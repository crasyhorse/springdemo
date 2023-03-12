package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.coach.CricketCoach;

public class App {

    public static void main(final String[] args) {
        try (
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
            );
        ) {
            CricketCoach coach = context.getBean(
                "cricketCoach",
                CricketCoach.class
            );

            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getDailyFortune());

            System.out.println(coach.getEmailAddress());
            System.out.println(coach.getTeam());
        }
    }
}
