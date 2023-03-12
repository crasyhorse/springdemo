package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.coach.Coach;

public class BeanLifeCycleApp {

    public static void main(final String[] args) {
        try (
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "beanLifeCycle-applicationContext.xml"
            );
        ) {
            Coach coach = context.getBean("trackCoach", Coach.class);

            System.out.println(coach.getDailyWorkout());
        }
    }
}
