package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.coach.Coach;

public class AnnotationApp {

    public static void main(final String[] args) {
        try (
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "annotationBased-applicationContext.xml"
            );
        ) {
            Coach coach = context.getBean("tennisCoach", Coach.class);
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getDailyFortune());
        }
    }
}
