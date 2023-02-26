package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.coach.SwimCoach;

public class JavaConfigApp {

    public static void main(final String[] args) {
        try (
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SportConfig.class
            );
        ) {
            SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getDailyFortune());
            System.out.println(String.format("Email: %s", coach.getEmail()));
            System.out.println(String.format("Team: %s", coach.getTeam()));
        }
    }
}
